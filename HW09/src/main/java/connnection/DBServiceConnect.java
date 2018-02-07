package connnection;
import base.DataSet;
import cashEngine.CasheEngineImpl;
import executor.Executor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBServiceConnect implements DBService {
    private final Connection connection;
    DBServiceConnect() {
        connection = ConnectionHelper.getConnection();
    }

    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint(20) auto_increment, name varchar(255), age int(3), primary key (id))";
    private static final String SHOW = "select * from user where id = ?";
    private static final String DROP_TABLE = "drop table user";
    private static final String INSERT_NAME = "insert into user (name) values (?)";
    private static final String WARNING = "Table doesn't have requested id (%d)";
    private static final String ADD_MASSAGE = "User added, rows changed: ";
    private static final String INSERT_USERS = "insert into user (name, age) values (?, ?)";
    private static final String AGE = "age";
    private static final String NAME = "name";
    private static final String SELECT_FROM_USER = "select * from user where id = ?";
    private static final String WARNING_TABLE_MISMATCH = "Warning table mismatch!!";

    public void prepareTables () {
            Executor logExecutor = new Executor(getConnection());
        try {
            logExecutor.execUpdate(CREATE_TABLE_USER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNames(String... names) {
        Executor updateExec = new Executor(getConnection());
        int row = 0;
        try {
            for (String name : names) {
                row = updateExec.execPreparedQuery(INSERT_NAME, result -> {
                    result.setString(1, name);
                    return result.executeUpdate();
                });
                System.out.println(ADD_MASSAGE + row);
            }
        } catch (Exception ex) {
            System.out.println(String.format("Table doesn't have requested name %d", names));
        }
    }

    @Override
    public String getUserName(int id) {
        String name = "";
            Executor executor = new Executor(getConnection());
            name = executor.execPreparedQuery(SHOW, result -> {
                result.setInt(1, id);
                ResultSet resultSet = result.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
                else return null;
            });

        return name;
    }

    @Override
    public void dropTable () {
        Executor executor = new Executor(getConnection());
        try {
            executor.execUpdate(DROP_TABLE);
        } catch (SQLException e) {
            System.out.println("Table doesn't exist!!!");
        }
    }

    @Override
    public List<String> getAllNames() {
        Executor executor = new Executor(getConnection());
        try {
            return executor.execQuery("select name from user", result -> {

                List<String> userList = new ArrayList<>();
                while (!result.isLast()) {
                    result.next();
                    userList.add(result.getString("name"));
                }
                return userList;

            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <K, V> CasheEngineImpl<K,V> getCashe() {
        return null;
    }

    @Override
    public String getMetaData() {
        try {
            return  "Connected to " + getConnection().getMetaData().getURL() + "\n" +
                    "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n"+
                    "DB version: " + getConnection().getMetaData().getDriverVersion() + "\n" +
                    "Driver: " + getConnection().getMetaData().getDriverName() + "\n";
        }
        catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    public <T extends DataSet> T loadUser2(long id, Class<T> clazz) {
        try {
            T dataSet = clazz.getConstructor().newInstance();
            Map<String, Object> mapTable;
            Executor exec = new Executor(getConnection());
//            try {
                mapTable = exec.execPreparedQuery(SELECT_FROM_USER, result -> {

                    int count = result.getMetaData().getColumnCount();
                    Map<String, Object> mappedTable = new HashMap<>();
                    ResultSet resultSet;
                    result.setLong(1, id);
                    resultSet = result.executeQuery();

                    resultSet.next();
                    for (int i = 1; i <= count; i++) {
                        Object colValue;
                        String colName = resultSet.getMetaData().getColumnName(i);
                        try {
                            colValue = resultSet.getObject(colName);
                        } catch (SQLException ex) {
                            System.out.println(String.format(WARNING, id));
                            return mappedTable;
                        }
                        mappedTable.put(colName, colValue);
                    }
                    return mappedTable;
                });
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
            try {
                for (Field field : dataSet.getClass().getDeclaredFields()) {
                    if (mapTable.containsKey(field.getName())) {
                        field.setAccessible(true);
                        field.set(dataSet, mapTable.get(field.getName()));
                        field.setAccessible(false);
                    }
                }
            } catch (IllegalAccessException ex) {
                System.out.println(WARNING_TABLE_MISMATCH);
                return dataSet;
            }

            return dataSet;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException {
        Map<String, Object> mappedObject = new HashMap<>();
        long id;
        boolean fieldAccessible = false;
        for (Field field : user.getClass().getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldAccessible = true;
            }
            try {
                mappedObject.put(field.getName(), field.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fieldAccessible) {
                field.setAccessible(false);
            }
        }
        try {
            Executor executor = new Executor(getConnection());

            id = executor.execPreparedQuery(INSERT_USERS, statement -> {
                statement.setObject(1, mappedObject.get(NAME));
                statement.setObject(2, mappedObject.get(AGE));
                statement.setString(0,"SELECT last_insert_id();");

                ResultSet resultSet = statement.executeQuery();
                return resultSet.getLong(1);
                //statement.execute();

            });
//            id = executor.execQuery("SELECT last_insert_id();", result -> {
//                result.next();
//                return result.getLong(1);
//            });
            mappedObject.put("id", id);
            getConnection().commit();
        } catch (SQLException ex) {
            getConnection().rollback();
        } finally {
            getConnection().setAutoCommit(true);
        }
    }

    @Override
    public <T extends DataSet> void saveUserCash(T user) {
    }

    @Override
    public void close() throws Exception {

        connection.close();

    }

    Connection getConnection() {
        return connection;
    }
}


package connnection;


import base.DBService;
import base.DataSet;
import executor.Executor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBServiceConnect implements DBService {
    private final Connection connection;

    public DBServiceConnect() {

        connection = ConnectionHelper.getConnection();
    }

    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint(20) auto_increment, name varchar(255), age int(3), primary key (id))";
    private static final String SHOW = "select * from user where id= '%s' ";
    private static final String DROP_TABLE = "drop table user";
    private static final String INSERT_NAME = "insert into user (name) values ('%s')";
    private static final String INSERT_USER = "insert into user (name, age) values ('%s', %d)";
    private static final String WARNING = "Table doesn't have requested id (%d)";
    private static final String ADD_MASSAGE = "User added, rows changed: ";

    public void prepareTables () throws SQLException{

        Executor logExecutor = new Executor(getConnection());
        logExecutor.execUpdate(CREATE_TABLE_USER);
    }

    @Override
    public void addNames(String... names) throws SQLException {
        Executor updateExec = new Executor(getConnection());
         for (String name: names) {
             int row = updateExec.execUpdate(String.format(INSERT_NAME, name));
             System.out.println(ADD_MASSAGE + row);
        }
    }

    @Override
    public String getUserName(int id) throws SQLException {
        try {
            Executor executor = new Executor(getConnection());

            executor.execQuery(String.format(SHOW, id), result -> {
                result.next();
                System.out.println("name: " + result.getString("name"));
            });
        } catch (Exception ex) {
            System.out.println(String.format(WARNING, id));
        }

     return null;
    }


    @Override
    public void dropTable () throws SQLException {
        Executor executor = new Executor(getConnection());
        executor.execUpdate(DROP_TABLE);
    }

    @Override
    public List<String> getAllNames() throws SQLException {
        Executor executor = new Executor(getConnection());
        return  executor.execQuery("select name from user" , result -> {

            List<String>  userList = new ArrayList<>();
            while (!result.isLast()) {
                result.next();
                userList.add(result.getString("name"));
            }
            return userList;

        });
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

    @Override
    public <T extends DataSet> T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        return null;
    }

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

    }

    @Override
    public void close() throws Exception {

        connection.close();

    }

    protected Connection getConnection() {
        return connection;
    }
}


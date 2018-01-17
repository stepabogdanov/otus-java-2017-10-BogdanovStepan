package connnection;

import base.DataSet;
import base.UserDataSet;
import executor.Executor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

public class DBServiceUpdate extends DBServiceConnection {

    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint(20) auto_increment, name varchar(255), age int(3), primary key (id))";
    private static final String SHOW = "select * from user where id= '%s' ";
    private static final String DROP_TABLE = "drop table user";
    private static final String INSERT_NAME = "insert into user (name) values ('%s')";
    private static final String INSERT_USER = "insert into user (name, age) values ('%s', %d)";

    public void prepareTables () throws SQLException{

        Executor logExecutor = new Executor(getConnection());
        logExecutor.execUpdate(CREATE_TABLE_USER);
    }

    @Override
    public void addNames(String... names) throws SQLException {
        Executor updateExec = new Executor(getConnection());
         for (String name: names) {
             int row = updateExec.execUpdate(String.format(INSERT_NAME, name));
             System.out.println("User added, rows changed: " + row);
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
            System.out.println("don't have data");
            System.exit(0);
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


/// HOMEWORK !!!

    public <T extends DataSet>  T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Class <?> c = Class.forName(clazz.getCanonicalName());

        T dataSet = (T) c.newInstance();


        List<String> fieldStringList = new ArrayList<>();
        fieldStringList.add("id");
        Map<String, Object> mapTable = new HashMap();

        Executor exec =  new Executor(getConnection());

        mapTable = exec.execQuery(String.format("select * from user where id = %d" , id), result -> {

            int count = result.getMetaData().getColumnCount();
            Map<String, Object> mappedTable = new HashMap<>();

            result.next();

            for (int i =1 ; i<=count; i++) {
                Object colValue = null;
                String colName = result.getMetaData().getColumnName(i);
                //System.out.println("colName:!!! " + colName);
                try {
                    colValue = result.getObject(colName);
                } catch (SQLException ex) {
                    System.out.println(String.format("Table doesn't have requested id (%d)", id));
                    return mappedTable;
                }
                mappedTable.put(colName, colValue);
            }

            //System.out.println(mappedTable);
            return mappedTable;
        });

        for (Field field: dataSet.getClass().getDeclaredFields()) {
            fieldStringList.add(field.getName());
            if (mapTable.containsKey(field.getName())) {
                field.setAccessible(true);
                field.set(dataSet, mapTable.get(field.getName()));
                field.setAccessible(false);
            }

        }

        //System.out.println(mapTable);
        return dataSet;
    }
}


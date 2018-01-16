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

    @Override
    public void saveUser(UserDataSet user) throws SQLException {
        Executor exec = new Executor(getConnection());
        exec.execUpdate(String.format(INSERT_USER, user.getName(), user.getAge()));
    }


    public <T extends DataSet>  T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException,
                                IllegalAccessException, InvocationTargetException,
                                InstantiationException, ClassNotFoundException {

        Class <?> c = Class.forName(clazz.getCanonicalName());

        Object dataSet = c.newInstance();


        List<String> fieldStringList = new ArrayList<>();
        fieldStringList.add("id");
        Map<String, Object> columnName = new HashMap();

        for (Field field: clazz.getDeclaredFields()) {
         fieldStringList.add(field.getName());
         //field.get(clazz);
//            field.set();
        }
        System.out.println("fields are: " + fieldStringList);


        Executor exec =  new Executor(getConnection());

        columnName = exec.execQuery("select * from user", result -> {
            int count = result.getMetaData().getColumnCount();
            Map<String, Object> mapTable = new HashMap<>();

            for (int i =1 ; i<=count; i++) {

                mapTable.put(result.getMetaData().getColumnName(i), result.getObject(Math.toIntExact(i));

            }

            return stringList;
        });
        System.out.println("column are: " + columnName);

        System.out.println(columnName.containsAll(fieldStringList));

        if



        return null;
    }
}


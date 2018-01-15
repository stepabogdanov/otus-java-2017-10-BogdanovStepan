package connnection;

import executor.Executor;

import java.sql.SQLException;

public class DBServiceUpdate extends DBServiceConnection {

    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint(20) auto_increment, name varchar(255), age int(3), primary key (id))";
    private static final String SHOW = "select * from user where id= '%s' ";
    private static final String DROP_TABLE = "drop table user";
    private static final String INSERT_USER = "insert into user (name) values ('%s')";

    public void prepareTables () throws SQLException{

        Executor logExecutor = new Executor(getConnection());
        logExecutor.execUpdate(CREATE_TABLE_USER);
    }

    @Override
    public void insertUsers (String... names) throws SQLException {
        Executor updateExec = new Executor(getConnection());
         for (String name: names) {
             int row = updateExec.execUpdate(String.format(INSERT_USER, name));
             System.out.println("User added, rows changed: " + row);
        }
    }

    @Override
    public String getUserName(int id) throws SQLException {
        Executor executor =  new Executor(getConnection());

         executor.execQuery(String.format(SHOW, id), result -> {
             result.next();
             System.out.println("name: " + result.getString("name"));
         });
     return null;
    }


    @Override
    public void dropTable () throws SQLException {
        Executor executor = new Executor(getConnection());
        executor.execUpdate(DROP_TABLE);
    }

}


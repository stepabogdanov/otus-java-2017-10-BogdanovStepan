package connnection;

import base.DBService;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.SQLException;

public class DBServiceConnection implements DBService {
    private final Connection connection;
    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint auto_increment, name varchar(256), primary key (id))";


    public DBServiceConnection() {
        connection = ConnectionHelper.getConnection();

    }

    @Override
    public String getMetaData() {
        try {
            String metData = "Connected to " + getConnection().getMetaData().getURL() + "\n" +
                    "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n"+
                    "DB version: " + getConnection().getMetaData().getDriverVersion() + "\n" +
                    "Driver: " + getConnection().getMetaData().getDriverName() + "\n";
            return metData;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    public void prepareTables() throws SQLException {

    }

    @Override
    public String getUserName(int id) throws SQLException {
        return null;
    }

    @Override
    public void insertUsers(String... names) throws SQLException {

    }

    @Override
    public void dropTable() throws SQLException {

    }

    @Override
    public void close() throws Exception {

    }

    protected Connection getConnection() {
        return connection;

    }
}

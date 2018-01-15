package connnection;

import base.DBService;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.SQLException;

public class DBServiceConnection implements DBService {
    private final Connection connection;

    public DBServiceConnection() {
        connection = ConnectionHelper.getConnection();

    }

    @Override
    public String getMetaData() {
        try {
            String metData = "Connected to " + getConnection().getMetaData().getURL() + "\n" +
                    "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n"+
                    "DB version: " + getConnection().getMetaData().getDriverVersion() + "\n" +
                    "Driver: " + getConnection().getMetaData().getDriverName() + "\n" +
                    "Other info: " + getConnection().getMetaData().getSystemFunctions();
            return metData;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    public void close() throws Exception {

    }

    private Connection getConnection() {
        return connection;

    }
}

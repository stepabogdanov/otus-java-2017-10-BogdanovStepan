package connnection;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    static Connection getConnection() {
        try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        String url = " ";

        return DriverManager.getConnection(url);
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}

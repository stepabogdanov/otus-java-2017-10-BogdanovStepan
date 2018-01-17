package connnection;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static Connection getConnection() {
        try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        String url = "jdbc:mysql://" +       //db type
                "localhost:" +               //host name
                "3306/" +                    //port
                "db_example?" +              //db name
                "user=tully&" +              //login
                "password=tully&" +          //password

                "useSSL=false";             //do not use Secure Sockets Layer

        return DriverManager.getConnection(url);
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}

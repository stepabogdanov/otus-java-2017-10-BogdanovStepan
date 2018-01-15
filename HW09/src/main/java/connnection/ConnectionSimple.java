package connnection;

import java.sql.SQLException;

public class ConnectionSimple extends DBServiceUpdate {
    private static final String SELECT_USER = "select name from user where id=%s";

    @Override
    public String getUserName(int id) throws SQLException {
    return null;

    };


}

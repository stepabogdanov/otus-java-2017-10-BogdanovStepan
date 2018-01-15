package logger;

import com.mysql.cj.api.mysqla.result.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultHandler  {
    public void handle (ResultSet result) throws SQLException;
}

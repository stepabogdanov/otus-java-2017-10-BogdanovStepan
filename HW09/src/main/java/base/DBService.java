package base;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {
    String getMetaData();
    void prepareTables () throws SQLException;
    String getUserName(int id) throws SQLException;
    void insertUsers (String... names) throws SQLException;
    void dropTable() throws SQLException;
    List<String> getAllNames() throws SQLException;

}

package base;

import java.sql.SQLException;

public interface DBService extends AutoCloseable {
    String getMetaData();
    void prepareTables () throws SQLException;
    String getUserName(int id) throws SQLException;
    void insertUsers (String... names) throws SQLException;
    void dropTable() throws SQLException;

}

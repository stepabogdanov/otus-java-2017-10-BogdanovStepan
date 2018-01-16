package base;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {
    String getMetaData();
    void prepareTables () throws SQLException;
    String getUserName(int id) throws SQLException;
    void addNames(String... names) throws SQLException;
    void dropTable() throws SQLException;
    List<String> getAllNames() throws SQLException;
    void saveUser(UserDataSet user) throws SQLException;
    UserDataSet loadUser (long id, Class<UserDataSet> clazz) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    public <T extends DataSet>  T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException;
}

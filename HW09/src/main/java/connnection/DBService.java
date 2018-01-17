package connnection;

import base.DataSet;

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
    <T extends DataSet>  T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException,
                                                                    IllegalAccessException, InvocationTargetException,
                                                                        InstantiationException, ClassNotFoundException,
                                                                        NoSuchFieldException;
    <T extends DataSet> void saveUser(T user) throws SQLException, IllegalAccessException, NoSuchMethodException,
                                                                InvocationTargetException, InstantiationException;
}

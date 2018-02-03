package connnection;

import base.DataSet;
import cashEngine.CashElement;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    <T extends DataSet, K,V> CashElement<K, V> saveUserWithCash(T user) throws SQLException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException;
}

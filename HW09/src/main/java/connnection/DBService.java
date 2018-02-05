package connnection;

import base.DataSet;
import cashEngine.CashElement;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DBService extends AutoCloseable {
    void getCash();

    String getMetaData();

    void prepareTables ();

    String getUserName(int id);

    void addNames(String... names);

    void dropTable();

    List<String> getAllNames();

    <T extends DataSet>  T loadUser2(long id, Class<T> clazz);

    <T extends DataSet> void saveUser(T user) throws SQLException;

    <T extends DataSet> void saveUserCash(T user) throws SQLException;




}

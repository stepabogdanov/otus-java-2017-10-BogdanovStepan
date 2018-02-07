package connnection;

import base.DataSet;
import cashEngine.CasheEngineImpl;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {
    <K,V> CasheEngineImpl getCashe();

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

package connnection;

import base.DBService;
import base.DataSet;
import base.UserDataSet;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBServiceConnection implements DBService {
    private final Connection connection;
    private static final String CREATE_TABLE_USER = "create table if not exists user (id bigint auto_increment, name varchar(256), primary key (id))";


    public DBServiceConnection() {
        connection = ConnectionHelper.getConnection();

    }

    @Override
    public String getMetaData() {
        try {
            String metData = "Connected to " + getConnection().getMetaData().getURL() + "\n" +
                    "DB name: " + getConnection().getMetaData().getDatabaseProductName() + "\n"+
                    "DB version: " + getConnection().getMetaData().getDriverVersion() + "\n" +
                    "Driver: " + getConnection().getMetaData().getDriverName() + "\n";
            return metData;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

    @Override
    public void prepareTables() throws SQLException {

    }

    @Override
    public String getUserName(int id) throws SQLException {
        return null;
    }

    @Override
    public void addNames(String... names) throws SQLException {

    }

    @Override
    public void dropTable() throws SQLException {

    }

    @Override
    public List<String> getAllNames() throws SQLException {
        return null;
    }

    @Override
    public void saveUser(UserDataSet user) throws SQLException {

    }

    @Override
    public UserDataSet loadUser(long id, Class<UserDataSet> clazz) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return null;
    }

    @Override
    public <T extends DataSet> T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        return null;
    }

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

    }

    @Override
    public void close() throws Exception {

    }

    protected Connection getConnection() {
        return connection;

    }
}

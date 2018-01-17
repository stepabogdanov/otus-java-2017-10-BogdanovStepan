package connnection;

import base.DataSet;
import executor.Executor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBServiceNew extends DBServiceUpdate {
    private static final String INSERT_USERS = "insert into user (?) values (?)";


    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException, IllegalAccessException, NoSuchMethodException,
                                                                    InvocationTargetException, InstantiationException {
        int fieldNum = 0;
        Object object = user.getClass().getConstructor().newInstance();
        Map<String, Object> mappedObject = new HashMap<>();
        for (Field field : object.getClass().getDeclaredFields()){
            fieldNum++;
            field.setAccessible(true);
            mappedObject.put(field.getName(), field.get(user));
            field.setAccessible(false);
        }
        System.out.println("Mapped Object: " + mappedObject);

        try {
            Executor executor = new Executor(getConnection());
            getConnection().setAutoCommit(false);
//            executor.execQuery(INSERT_USERS, statement -> {
//
//            });

            getConnection().commit();
        } catch (SQLException ex) {
            getConnection().rollback();
        } finally {
            getConnection().setAutoCommit(true);
        }


    }
}

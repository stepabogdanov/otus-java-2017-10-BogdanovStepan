package connnection;

import base.DataSet;
import base.UserDataSet;
import cashEngine.CashElement;
import cashEngine.CashEngineImpl;
import executor.Executor;
import sun.security.provider.MD5;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBServiceCash extends DBServiceConnect {
    private Connection connection;

    private static final String INSERT_USERS = "insert into user (name, age) values (?, ?)";
    private static final String WARNING = "Warning table doesn't have requested id (%d)";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private  CashEngineImpl<Long, DataSet> cash = CashEngineImpl.createEngine(2, 10, 10, true);
   private static int ii = 0;

    @Override
    public <T extends DataSet> T loadUser2(long id, Class<T> clazz) {
        if (cash.get(id) == null) {
            return super.loadUser2(id, clazz);
        } else {
            cash.get(id).getValue();
        }
        return null;
    }

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException {

        UserDataSet dataSet = new UserDataSet();

        Long id = null;
        boolean fieldAccessible = false;
        Map<String, Object> mappedObjectCash = new HashMap<>();

        for (Field field : user.getClass().getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldAccessible = true;
            }
            try {
                mappedObjectCash.put(field.getName(), field.get(user));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                if (fieldAccessible) {
                    field.setAccessible(false);
                }
            }
        }

        try {
            Executor executor = new Executor(getConnection());
            getConnection().setAutoCommit(false);

            executor.execPreparedQuery(INSERT_USERS, statement -> {
                statement.setObject(1, mappedObjectCash.get(NAME));
                statement.setObject(2, mappedObjectCash.get(AGE));
                statement.execute();

            });
            id = executor.execQuery("SELECT last_insert_id();", result -> {
                result.next();
                return result.getLong(1);
            });
            mappedObjectCash.put("id", id);
            getConnection().commit();

        } catch (SQLException ex) {
            getConnection().rollback();
        } finally {
            getConnection().setAutoCommit(true);
        }

        try {
            for (Field field : dataSet.getClass().getDeclaredFields()) {
                if (mappedObjectCash.containsKey(field.getName())) {
                    field.setAccessible(true);
                    field.set(dataSet, mappedObjectCash.get(field.getName()));
                    field.setAccessible(false);
                }
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

        cash.put(new CashElement<>((Long) mappedObjectCash.get("id"), dataSet));



    }
    public void getCash() {
        System.out.println("Cash: " + cash);
    }
}



//System.out.println(cash);

//        long l = System.currentTimeMillis();
//
//        String s = "This is a test" + ii;
//
//        MessageDigest m = null;
//        try {
//            m = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        m.update(s.getBytes(), 0, s.length());
//        System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));
//        System.out.println(System.currentTimeMillis()-l);
//        ii++;




package connnection;

import base.DataSet;
import cashEngine.CashElement;
import cashEngine.CashEngine;
import cashEngine.CashEngineHandler;
import cashEngine.CashEngineImpl;
import executor.Executor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBServiceNew extends DBServiceConnect {
    private Connection connection;

    private static final String WARNING_TABLE_MISMATCH = "Warning table mismatch!!";
    private static final String INSERT_USERS = "insert into user (name, age) values (?, ?)";
    private static final String SELECT_FROM_USER = "select * from user where id = %d";
    private static final String WARNING = "Warning table doesn't have requested id (%d)";
    private static final String NAME_COLUMN = "name";
    private static final String AGE_COLUMN = "age";

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException, IllegalAccessException {
        Map<String, Object> mappedObject = new HashMap<>();
        long id = 0;
        boolean fieldAccessible = false;
        for (Field field : user.getClass().getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldAccessible = true;
            }
            mappedObject.put(field.getName(), field.get(user));
            if (fieldAccessible) {
                field.setAccessible(false);
            }
        }

        try {
            Executor executor = new Executor(getConnection());
            getConnection().setAutoCommit(false);

            executor.execPreparedQuery(INSERT_USERS, statement -> {
                statement.setObject(1, mappedObject.get(NAME_COLUMN));

                statement.setObject(2, mappedObject.get(AGE_COLUMN));
                statement.execute();

            });
            id = executor.execQuery("SELECT last_insert_id();", result -> {
                result.next();
                return result.getLong(1);
            });
            mappedObject.put("id", id);
            //System.out.println(mappedObject);
            getConnection().commit();
        } catch (SQLException ex) {
            getConnection().rollback();
        } finally {
            getConnection().setAutoCommit(true);
        }

    }

    public <T extends DataSet> T loadUser2(long id, Class<T> clazz) throws SQLException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException, NoSuchFieldException {

        T dataSet = clazz.getConstructor().newInstance();

        Map<String, Object> mapTable;
        Executor exec = new Executor(getConnection());
        mapTable = exec.execQuery(String.format(SELECT_FROM_USER, id), result -> {

            int count = result.getMetaData().getColumnCount();
            Map<String, Object> mappedTable = new HashMap<>();

            result.next();
            for (int i = 1; i <= count; i++) {
                Object colValue;
                String colName = result.getMetaData().getColumnName(i);
                try {
                    colValue = result.getObject(colName);
                } catch (SQLException ex) {
                    System.out.println(String.format(WARNING, id));
                    return mappedTable;
                }
                mappedTable.put(colName, colValue);
            }
            return mappedTable;
        });
        try {
            for (Field field : dataSet.getClass().getDeclaredFields()) {
                if (mapTable.containsKey(field.getName())) {
                    field.setAccessible(true);
                    field.set(dataSet, mapTable.get(field.getName()));
                    field.setAccessible(false);
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(WARNING_TABLE_MISMATCH);
            return dataSet;
        }
        return dataSet;
    }

    @Override
    public <T extends DataSet, K, V> CashElement<K, V> saveUserWithCash(T userS) throws SQLException, IllegalAccessException {
        Long id = null;
        boolean fieldAccessible = false;
        Map<String, Object> mappedObjectCash = new HashMap<>();
        CashElement<K, V> cashElement;

        for (Field field : userS.getClass().getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldAccessible = true;
            }
            mappedObjectCash.put(field.getName(),field.get(userS));
            if (fieldAccessible)  {
                field.setAccessible(false);
            }
        }

        try {
            Executor executor = new Executor(getConnection());
            getConnection().setAutoCommit(false);

            executor.execPreparedQuery(INSERT_USERS, statement -> {
                statement.setObject(1, mappedObjectCash.get(NAME_COLUMN));

                statement.setObject(2, mappedObjectCash.get(AGE_COLUMN));
                statement.execute();

            });
            id = executor.execQuery("SELECT last_insert_id();", result -> {
                result.next();
                return result.getLong(1);
            });
            mappedObjectCash.put("id", id);
            //System.out.println(mappedObject);
            getConnection().commit();

        } catch (SQLException ex) {
            getConnection().rollback();
        } finally {
            getConnection().setAutoCommit(true);
        }

        return cashElement = new CashElement<>( (K) id, (V) mappedObjectCash);
    }

}


package connnection;

import base.DataSet;
import base.UserDataSet;
import cacheEngine.CacheElement;
import cacheEngine.CacheEngineImpl;
import executor.Executor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBServiceCache extends DBServiceConnect {
    private Connection connection;

    private final int maxElement = 4;
    private final long lifeTimeMs = 100;
    private final long idleTimeMs = 100;
    private final boolean isEternal = true;
    private static final String INSERT_USERS = "insert into user (name, age) values (?, ?)";
    private static final String WARNING = "Warning table doesn't have requested id (%d)";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private final CacheEngineImpl<Long, DataSet> cache = CacheEngineImpl.createEngine(maxElement, lifeTimeMs, idleTimeMs, isEternal);
    private static int ii = 0;

    @Override
    public <T extends DataSet> T loadUser2(long id, Class<T> clazz) {
        CacheElement cacheElement = cache.get(id);
        if (cacheElement == null) {
            return super.loadUser2(id, clazz);
        } else {
            return (T) cacheElement.getValue();
        }
    }

    @Override
    public <T extends DataSet> void saveUser(T user) throws SQLException {

        UserDataSet dataSet = new UserDataSet();

        Long id;
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

        cache.put(new CacheElement<>((Long) mappedObjectCash.get("id"), dataSet));
    }
    public <K, V> CacheEngineImpl<K, V> getCache() {
        return (CacheEngineImpl<K, V>) cache;
    }
}

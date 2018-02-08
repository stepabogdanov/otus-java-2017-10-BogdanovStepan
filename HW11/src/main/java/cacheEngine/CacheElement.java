package cacheEngine;

public class CacheElement<K,V> {
    private final K key;
    private final V value;
    private  final long creationTime;
    private long lastAccessTime;

    public CacheElement(K key, V value) {
        this.key = key;
        this.value = value;
        this.creationTime = getCurrentTime();
        this.lastAccessTime = getCurrentTime();
    }

    protected long getCurrentTime() {
        return System.currentTimeMillis();
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setLastAccessed(long lastAccessTime) {
        this.lastAccessTime = getCurrentTime();
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}

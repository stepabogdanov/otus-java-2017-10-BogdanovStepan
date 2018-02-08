package cacheEngine;

@SuppressWarnings("WeakerAccess")
public interface CachEngine<K,V> {

    void put(CacheElement<K, V> dataSetElement);
    CacheElement<K, V> get(K key);

    int getHitCount();
    int getMissCount();
    void dispose();

}

package cacheEngine;

@SuppressWarnings("WeakerAccess")
public interface CashEngine<K,V> {

    void put(CasheElement<K,V> dataSetElement);
    CasheElement<K, V> get(K key);

    int getHitCount();
    int getMissCount();
    void dispose();

}

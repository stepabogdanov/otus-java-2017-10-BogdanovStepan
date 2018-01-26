package cashEngine;

import base.DataSet;

public interface CashEngine<K,V> {

    void put(CashElement<K,V> dataSetElement);
    CashElement <K, V> get(K key);

    int getHitCount();
    int getMissCount();
    void dispose();

}

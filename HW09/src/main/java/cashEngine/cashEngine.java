package cashEngine;

import base.DataSet;

public interface cashEngine <K,V> {
    void put(CashElement<K,V> dataSetElement);
}

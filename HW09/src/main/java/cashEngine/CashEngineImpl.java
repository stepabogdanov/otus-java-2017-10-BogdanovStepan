package cashEngine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

public class CashEngineImpl <K,V> implements CashEngine<K,V> {
    private static final int TIME_THRESHOLD = 5;
    private final int maxElement;
    private final long lifeTimeMs;
    private final long edleTimeMs;
    private final boolean isEternal;
    private final Map<K, CashElement<K,V>> elements = new LinkedHashMap<>();
    //private final Timer timer = new Timer();

    private int hit = 0;
    private int miss = 0;

    public CashEngineImpl(int maxElement, long lifeTimeMs, long edleTimeMs, boolean isEternal) {
        this.maxElement = maxElement;
        this.lifeTimeMs = lifeTimeMs; //> 0 ? lifeTimeMs : 0;
        this.edleTimeMs = edleTimeMs; //> 0 ? edleTimeMs :0;
        this.isEternal = isEternal;
    }

    @Override
    public void put(CashElement<K, V> element) {
        if (elements.size() == maxElement) {
            K firstKey = elements.keySet().iterator().next();
            elements.remove(firstKey);
        }

        K key = element.getKey();
        elements.put(key, element);

    }

    @Override
    public CashElement<K, V> get(K key) {
        CashElement<K, V> element = elements.get(key);
        if (element == null) {
            miss++;
        }
        else hit++;
        return element;
    }

    @Override
    public int getHitCount() {
        return hit;
    }

    @Override
    public int getMissCount() {
        return miss;
    }

    @Override
    public void dispose() {

    }
//    private CashEngine<K, V> buildDefault(){
//        CashEngineImpl<K, V> cashEngine = new CashEngineImpl<>(5,100,1000, false) ;
//        return cashEngine;
//    }

    @Override
    public String toString() {
        return elements.toString();
    }
}

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
    private final Timer timer = new Timer();

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
        K key = element.getKey();
        elements.put(key, element);

    }

    @Override
    public CashElement<K, V> get(K key) {
        return null;
    }

    @Override
    public int getHitCount() {
        return 0;
    }

    @Override
    public int getMissCount() {
        return 0;
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

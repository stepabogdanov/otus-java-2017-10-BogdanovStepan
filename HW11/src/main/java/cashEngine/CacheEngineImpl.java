package cashEngine;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// TODO: 07.02.18 realize time life of cashe

public class CacheEngineImpl<K,V> implements CachEngine<K,V> {
    private static final int TIME_THRESHOLD = 5;
    private int maxElement;
    private long lifeTimeMs;
    private long idleTimeMs;
    private boolean isEternal;
    private final Map<K, SoftReference<CacheElement<K,V>>> elements = new LinkedHashMap<>();
    //private final Timer timer = new Timer();

    private int hit = 0;
    private int miss = 0;

    private CacheEngineImpl(int maxElement, long lifeTimeMs, long idleTimeMs, boolean isEternal) {
        this.maxElement = maxElement;
        this.lifeTimeMs = lifeTimeMs > 0 ? lifeTimeMs : 0;
        this.idleTimeMs = idleTimeMs > 0 ? idleTimeMs : 0;
        this.isEternal = lifeTimeMs == 0 && idleTimeMs ==0 || isEternal;
    }

    @Override
    public void put(CacheElement<K, V> element) {
        if (elements.size() == maxElement) {
            K firstKey = elements.keySet().iterator().next();
            elements.remove(firstKey);
        }

        K key = element.getKey();
        elements.put(key, new SoftReference<>(element));

    }

    @Override
    public CacheElement<K, V> get(K key) {
        CacheElement<K, V> element = null;

        if (elements.get(key) != null) {
            element = elements.get(key).get();
        }
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

    @Override
    public String toString() {
        Map<K, CacheElement<K,V>> map = new HashMap<>();
        for (K key : elements.keySet()) {
            map.put(key, elements.get(key).get());
        }
        return map.toString();
    }

    public static <K,V> CacheEngineImpl<K,V> createEngine(int maxElement, long lifeTimeMs, long edleTimeMs, boolean isEternal) {
         return new CacheEngineImpl<>(maxElement, lifeTimeMs, edleTimeMs, isEternal);

    }

    public void setMaxElement(int maxElement) {
        this.maxElement = maxElement;
    }

    public void setLifeTimeMs(long lifeTimeMs) {
        this.lifeTimeMs = lifeTimeMs;
    }

    public void setIdleTimeMs(long idleTimeMs) {
        this.idleTimeMs = idleTimeMs;
    }

    public void setEternal(boolean eternal) {
        isEternal = eternal;
    }
}

package com.zr.javase.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhourui
 * @Date 2021/3/20 10:30
 */
public class LRUCache<K, V> {

    private static final float DEFAULT_LOAD_FACTORY = 0.75F;

    private static final int MAX_CACHE_SIZE = 10;

    private final LinkedHashMap map;

    public LRUCache() {
        map = new LinkedHashMap(16, DEFAULT_LOAD_FACTORY, true);
    }

    public LRUCache(int initialCapacity) {
        map = new LinkedHashMap(initialCapacity, DEFAULT_LOAD_FACTORY, true);
    }

    public void put(K k, V v) {
        map.put(k, v);
    }

    public V get(K k) {
        return (V) map.get(k);
    }

    public int size() {
        return map.size();
    }

    public void remove(K k) {
        map.remove(k);
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    private class MyLinkedHashMap extends LinkedHashMap<K, V> {
        public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return MAX_CACHE_SIZE < size();
        }
    }

}

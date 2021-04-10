package com.zr.javase.algorithm.lfu;

import java.util.*;

/**
 * @Author zhourui
 * @Date 2021/3/24 14:27
 */
public class LFUCache<K, V> {

    /**
     * 总容量
     */
    private int capacity;

    /**
     * 所有的node节点
     */
    private Map<K, Node> caches;

    public LFUCache(int size) {
        this.capacity = size;
        caches = new LinkedHashMap<K, Node>(size);
    }

    public void put(K key, V value) {
        Node node = caches.get(key);
        /*如果新元素*/
        if (node == null) {
            if (caches.size() >= capacity) {
                K leastKey = removeLeastCount();
                caches.remove(leastKey);
            }
            /*创建新节点*/
            node = new Node(key, value, System.nanoTime(), 1);
            caches.put(key, node);
        } else {
            node.value = value;
            node.setCount(node.getCount() + 1);
            node.setTime(System.nanoTime());
        }
        sort();
    }

    private void sort() {
        List<Map.Entry<K, Node>> list = new ArrayList<>(caches.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, Node>>() {
            @Override
            public int compare(Map.Entry<K, Node> kNodeEntry, Map.Entry<K, Node> t1) {
                return t1.getValue().compareTo(kNodeEntry.getValue());
            }
        });

        caches.clear();
        for (Map.Entry<K, Node> kNodeEntry : list) {
            caches.put(kNodeEntry.getKey(), kNodeEntry.getValue());
        }
    }

    private K removeLeastCount() {
        Collection<Node> values = caches.values();
        Node min = Collections.min(values);
        return (K) min.getKey();
    }

    public V get(K key) {
        Node node = caches.get(key);
        if (node != null) {
            node.setCount(node.getCount() + 1);
            node.setTime(System.nanoTime());
            sort();
            return (V) node.value;
        }
        return null;
    }

    public static void main(String[] args) {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(5);
        lfuCache.put(1, "A");
        lfuCache.put(2, "B");
        lfuCache.put(3, "C");
        lfuCache.put(4, "D");
        lfuCache.put(5, "E");
        lfuCache.put(6, "F");

        lfuCache.get(2);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.get(6);

        lfuCache.put(3, "C");

        final Map<Integer, Node> caches = lfuCache.caches;
        for (Map.Entry<Integer, Node> nodeEntry : caches.entrySet()) {
            System.out.println(nodeEntry.getValue().value);
        }
    }
}

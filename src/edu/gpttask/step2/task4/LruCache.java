package edu.gpttask.step2.task4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Реализовать LRU Cache через LinkedHashMap
 * @param <K>
 * @param <V>
 */

public class LruCache<K, V>  extends LinkedHashMap<K, V> {
    final int maxSize;

    public LruCache(int maxSize) {
        super(computeCapacity(maxSize, 0.75f), 0.75f, true);
        this.maxSize = maxSize;
    }

    public static int computeCapacity(int maxSize, float loadFactor) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Размер кэша должен быть > 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Коэффициент загрузки  должен быть > 0");
        }
        int cap = (int) Math.ceil(maxSize/loadFactor) + 1;
        return Math.max(16, cap);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    public V getOrLoad(K key, DataBase<K,V> dataBase) {
        V value = this.get(key);
        if (value != null) {
            return value;
        }
        return this.computeIfAbsent(key, dataBase::load);
    }


}

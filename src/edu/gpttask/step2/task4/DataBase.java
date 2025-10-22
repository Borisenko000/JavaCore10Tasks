package edu.gpttask.step2.task4;

import java.util.HashMap;
import java.util.Map;

public class DataBase<K, V>  {
    private final Map<K, V> source;

    public DataBase(Map<K, V> source) {
        this.source = Map.copyOf(source);
    }

    public V load(K key) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
        }
        return source.get(key);
    }

}

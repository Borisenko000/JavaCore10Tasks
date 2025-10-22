package edu.gpttask.step2.task4;

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {

        LruCache<String, Integer> cache = new LruCache<>(4);
        Map<String, Integer> source = new HashMap<>();
        source.put("просто", 2643);
        source.put("рандомный", 222);
        source.put("пример", 666);
        source.put("ляляля", 110);
        source.put("еще что-то",343);
        DataBase<String, Integer> dataBase = new DataBase<>(source);
        cache.getOrLoad("просто", dataBase);
        cache.getOrLoad("пример", dataBase);
        cache.getOrLoad("ляляля", dataBase);
        cache.getOrLoad("рандомный", dataBase);
        System.out.println("База данных в кэше");
        cache.forEach((k, v) -> System.out.println(k + " - " + v));
        cache.getOrLoad("просто", dataBase);
        System.out.println("После взаимодействия с первым элементом");
        cache.forEach((k, v) -> System.out.println(k + " - " + v));
        cache.getOrLoad("еще что-то", dataBase);
        System.out.println("После переполнения кэша");
        cache.forEach((k, v) -> System.out.println(k + " - " + v));






    }
}


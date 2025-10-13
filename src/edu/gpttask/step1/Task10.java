package edu.gpttask.step1;

import java.util.*;

/**
 *  Реализовать метод removeDuplicates(List<T>), который убирает дубликаты.
 */

public class Task10 {
    public static void main(String[] args) {
        List<String> list = List.of("Привет", "этот", "метод", "удаляет", "дубликат" ,  "дубликат");
        List<String> listWithoutDuplicates = removeDuplicates(list);
        System.out.println(listWithoutDuplicates);

    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        if (list == null) {
            throw new NullPointerException("Список равен null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
        Set<T> set = new LinkedHashSet<>(list);
        List<T> listWithoitDuplicates = new ArrayList<>(set.size());
        set.stream().forEachOrdered(listWithoitDuplicates::add);
        return listWithoitDuplicates;
    }
}

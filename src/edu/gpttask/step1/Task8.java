package edu.gpttask.step1;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 *  Написать метод, который считает сумму цифр числа (123 → 6).
 */

public class Task8 {
    public static void main(String[] args) {
        List<String> list = List.of("h", "e", "l", "l", "o");
        String str1 = ListToStringByCycle(list);
        System.out.println(str1 + " - формирование строки через цикл");
        String str2 = ListToStringByStream(list);
        System.out.println(str2 + " - формирование строки через stream");
        String str3 = ListToStringByJoin(list);
        System.out.println(str3 + " - формирование строки через join");
    }


    public static String ListToStringByCycle(List<String> list) {
        if (list == null) {
            throw new NullPointerException("Список равен null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < list.size() - 1; i++) {
            joiner.add(list.get(i));
            joiner.add(", ");
        }
        joiner.add(list.getLast());
        return joiner.toString();
    }

    public static String ListToStringByStream(List<String> list) {
        if (list == null) {
            throw new NullPointerException("Список равен null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
        return list.stream().collect(Collectors.joining(", "));
    }

    public static String ListToStringByJoin(List<String> list) {
        if (list == null) {
            throw new NullPointerException("Список равен null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
        return String.join(", ", list);
    }
}

package edu.gpttask.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Удалить из списка все чётные числа.
 */

public class Task6 {
    public static void main(String[] args) {
        List<Integer> listInt = List.of(1,4,75, 24,9,4,2);
        List<Integer> result1 = deleteEvenNumbersStream(listInt);
        System.out.println(result1);
        List<Integer> result2 = deleteEvenNumbersCycle(listInt);
        System.out.println(result2);
    }

    public static List<Integer> deleteEvenNumbersStream(List<Integer> listInt) {
        if (listInt == null) {
            throw new NullPointerException("Список равен null");
        }
        if (listInt.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
         return listInt.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
    }

    public static List<Integer> deleteEvenNumbersCycle(List<Integer> listInt) {
        if (listInt == null) {
            throw new NullPointerException("Список равен null");
        }
        if (listInt.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
        List<Integer> resultList = new ArrayList<>();
        for (Integer i : listInt) {
            if (i % 2 == 1) {
                resultList.add(i);
            }
        }
        return resultList;
    }
}

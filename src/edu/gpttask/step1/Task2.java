package edu.gpttask.step1;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 *  Найти максимальное и минимальное число в массиве int[].
 */

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 4, 77, 9};
        findMinAndMaxCycle(array);
        findMinAndMaxStream(array);

    }

    public static void findMinAndMaxCycle(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }
        System.out.printf("%d - минимальное число\n", min);
        System.out.printf("%d - максимальное число\n", max);
    }

    public static void findMinAndMaxStream(int[] array) {
        OptionalInt min = Arrays.stream(array).min();
        OptionalInt max = Arrays.stream(array).max();
        min.ifPresentOrElse(m -> System.out.printf("%d - минимальное число\n", m), () -> System.out.println("min is Empty"));
        max.ifPresentOrElse(m -> System.out.printf("%d - максимальное число\n", m), () -> System.out.println("max is Empty"));
    }
}

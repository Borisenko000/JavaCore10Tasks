package edu.gpttask.step1;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Подсчитать количество уникальных слов в тексте (через Set).
 */

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int sum = countUniqWords(text);
        System.out.println(sum);
    }

    public static int countUniqWords(String text) {
        if (text == null) {
            throw new NullPointerException("Текст равен null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Текст пустой");
        }
        Set<String> wordsSet = Arrays.stream(text.split("[^\\p{L}]+")).map(String::toLowerCase).collect(Collectors.toSet());
        return wordsSet.size();
    }


}

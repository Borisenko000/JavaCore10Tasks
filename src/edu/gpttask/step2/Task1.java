package edu.gpttask.step2;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Подсчитать частоту букв в строке (Map<Character, Integer>)
 */

public class Task1 {
    public static void main(String[] args) {
        String str  = "Привет, как дела?";
        System.out.println(countChar(str));
    }


    public static Map<Character, Integer> countChar(String str) {
        if (str == null) {
            throw new NullPointerException("Строка равна нулю");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая");
        }
        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(c -> c, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

    }
}
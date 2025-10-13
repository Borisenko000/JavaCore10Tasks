package edu.gpttask.step1;

import static java.lang.Character.isLetter;

/**
 *  Проверить, является ли слово палиндромом.
 */

public class Task4 {
    public static void main(String[] args) {
        String str = "Лидер бодро, гордо бредил.";
        System.out.println("Строка '" + str + "' - палиндром?: " + isPalindromeCycle(str));
        System.out.println("Строка '" + str + "' - палиндром?: " + isPalindromeStream(str));
    }

    public static boolean isPalindromeStream(String str) {
        if (str == null) {
            throw new NullPointerException("Строка равна null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая");
        }
        StringBuilder builder = new StringBuilder(str.length());
        str.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .filter(Character::isLetter)
                .forEach(builder::append);
        return builder.toString().contentEquals(builder.reverse());
    }

    public static boolean isPalindromeCycle(String str) {
        if (str == null) {
            throw new NullPointerException("Строка равна null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая");
        }
        char[] strToArray = str.toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder(str.length());
        for (char c : strToArray) {
            if (!isLetter(c)) {
                continue;
            }
            builder.append(c);
        }
        return builder.toString().contentEquals(builder.reverse());    }
}

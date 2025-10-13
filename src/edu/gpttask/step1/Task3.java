package edu.gpttask.step1;

/**
 *  Перевернуть строку ("abc" → "cba").
 */

public class Task3 {
    public static void main(String[] args) {
        String str1 = reversedString("Полина");
        System.out.println(str1);
        String str2 = reversedStringFast("Polina");
        System.out.println(str2);
    }

    public static String reversedString(String str) {
        if (str == null) {
            throw new NullPointerException("Строка равна null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая");
        }
        StringBuilder builder = new StringBuilder(str.length());
        char[] stringToChar = str.toCharArray();
        for (int i = stringToChar.length - 1; i >= 0; i--) {
            char ch = stringToChar[i];
            builder.append(ch);
        }
        return builder.toString();
    }

    public static String reversedStringFast(String str) {
        if (str == null) {
            throw new NullPointerException("Строка равна null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая");
        }
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }

}

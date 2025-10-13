package edu.gpttask.step1;

/**
 * Написать метод, который считает количество букв a в строке.
 */

public class Task1 {
    public static void main(String[] args) {
        System.out.println(countingCharA("banana"));
    }

    public static int countingCharA(String str) {
        char[] charArray = str.toCharArray();
        int sum = 0;
        for(char c:charArray) {
            if (c == 'a' || c == 'A') {
                sum++;
            }
        }
        return sum;
    }
}

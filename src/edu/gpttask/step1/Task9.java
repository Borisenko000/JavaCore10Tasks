package edu.gpttask.step1;

/**
 *  Сформировать строку из списка слов через запятую (["a", "b", "c"] → "a, b, c").
 */

public class Task9 {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(sumOfNumByStream(num) + " - подсчет суммы через поток");
        System.out.println(sumOfNumByCycle(num) + " - подсчет суммы через цикл");
    }

    public static int sumOfNumByStream(int num) {
        return String.valueOf(num).chars().map(Character :: getNumericValue).sum();
    }

    public static int sumOfNumByCycle(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int sum = 0;
        for (char c : array) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
}

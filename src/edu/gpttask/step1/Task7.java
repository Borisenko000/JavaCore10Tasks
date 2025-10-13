package edu.gpttask.step1;

/**
 *  Найти второе по величине число в массиве.
 */

public class Task7 {
    public static void main(String[] args) {
        int[] array = new int[] {1,5,94,6,257,8,0};
        int result = findSecondBigNumber(array);
        System.out.println(result);
    }

    public static int findSecondBigNumber(int[] array) {
        if (array == null) {
            throw new NullPointerException("Массив равен null");
        }
        if (array.length == 1) {
            throw new IllegalArgumentException("Один элемент в массиве");
        }
        int max1;
        int max2;
        max1 = Math.max(array[0], array[1]);
        max2 = Math.min(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            if (array[i] > max1) {
                max2 = max1;
                max1 = array[i];
            }
            else if (array[i] > max2) {
                max2 = array[i];
            }
        }
        return max2;
    }
}


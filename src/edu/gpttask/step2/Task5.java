package edu.gpttask.step2;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Написать метод, который ищет все анаграммы слова в списке слов
 */
public class Task5 {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("стил");
        test.add("слит");
        test.add("тильс");
        test.add("листок");
        test.add("лис");
        test.add("стул");
        test.add("тисл");
        test.add("пыль");
        test.add("сильт");
        test.add("лист");
        test.add("листы");
        List<String> anagrams = foundAnagrams(test, "лист");
        anagrams.stream().forEach(System.out :: println);
    }

    public static List<String> foundAnagrams(List<String> list, String str) {
        List<String> anagrams = new ArrayList<>();
        List<StringHelper> words = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            words.set(i, new StringHelper(list.get(i)));
        }
        for (StringHelper word : words) {
            if (word.isAnagramme(str)) {
                anagrams.add(word.get());
            }
        }
        return anagrams;
    }




}

class StringHelper {
    String str;

    public StringHelper(String str) {
        this.str = str;


    }
    public boolean isAnagramme(String str2) {
        int sum = 0;
        if (str.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            for (int z = 1; z <charArray2.length; z++) {
                if (charArray1[i] == charArray2[z]) {
                    sum++;
                    char[] charNewArray1 = new char[0];
                    char[] charNewArray2 = new char[0];
                    System.arraycopy(charArray1, 0, charNewArray1, 0, i);
                    System.arraycopy(charArray1, i + 1, charNewArray1, i, charArray1.length - i - 1);
                    System.arraycopy(charArray2, 0, charNewArray2, 0, i);
                    System.arraycopy(charArray2, i + 1, charNewArray2, i, charArray2.length - i - 1);
                    charArray1 = charNewArray1;
                    charArray2 = charNewArray2;
                }
            }
        }
        if (sum == str.length()) {
            return true;
        }
        return false;
    }

    public String get() {
        return this.str;
    }
}

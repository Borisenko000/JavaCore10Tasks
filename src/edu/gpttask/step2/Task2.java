package edu.gpttask.step2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Подсчитать частоту слов в тексте (Map<String, Integer>)
 */

public class Task2 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\fact.txt");
        System.out.println(countWords(path));

    }

    public static Map<String, Integer> countWords(Path path) {
        if (path == null) {
            throw new NullPointerException("Путь равен null");
        }
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("Файл не найден");
        }
        List<String> text = new ArrayList<>();
        try {
            text = Files.readAllLines(path);
        } catch (IOException _) {
            System.out.println("Ошибка ввода-вывода");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Текст пустой");
        }
        return text.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^\\p{L}]+", ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(str -> str, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

    }
}

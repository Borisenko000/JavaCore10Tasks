package edu.gpttask.step2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\fact.txt");
        System.out.println(countSortedWords(path));

    }

    public static Map<String, Integer> countSortedWords(Path path) {
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
         Map<String, Integer> map = text.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^\\p{L}]+", ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(str -> str, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }
}

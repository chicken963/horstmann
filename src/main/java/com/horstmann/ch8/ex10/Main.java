package com.horstmann.ch8.ex10;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.horstmann.ch8.ex7.Main.scanFile;

/**
 * Определите все символьные строки максимальной длины в заданном конечном потоке символьных строк.
 */
public class Main {
    public static void main(String[] args) {
        List<String> words = scanFile("chapters/com/horstmann/ch8/ex9/content.txt");
        Stream<String> wordsStream = words.stream();
        Map<String, Integer> wordsWithLengths = mapWordsWithLength(wordsStream);
        int maxLength = wordsWithLengths.values().stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getMax();
        List<String> maxLengthWords = wordsWithLengths.keySet().stream()
                .filter(w -> w.length() == maxLength)
                .collect(Collectors.toList());
        for (String word : maxLengthWords) {
            System.out.println(word);
        }
    }

    public static Map<String, Integer> mapWordsWithLength(Stream<String> wordsStream) {
        return wordsStream.collect(Collectors.toMap(Function.identity(), String::length, (e, n) -> e));
    }
}

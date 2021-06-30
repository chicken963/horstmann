package com.horstmann.ch8.ex16;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.horstmann.ch8.ex10.Main.mapWordsWithLength;
import static com.horstmann.ch8.ex6.Main.alphabetize;
import static com.horstmann.ch8.ex7.Main.entriesSortedByValues;
import static com.horstmann.ch8.ex7.Main.scanFile;

/**
 * Найдите 500 самых длинных слов в романе "Война и мир", используя параллельный поток данных.
 * Насколько это делается быстрее, чем при использовании последовательного потока данных?
 */
public class Main {
    public static void main(String[] args) {
        findNLongestWords("chapters/com/horstmann/ch8/ex16/warAndPeace.txt", 500);
        findNLongestWordsInParallel("chapters/com/horstmann/ch8/ex16/warAndPeace.txt", 500);
    }

    private static List<String> findNLongestWords(String src, int n){
        long startDate = System.currentTimeMillis();
        List<String> words = scanFile(src);
        Stream<String> stringStream = words.stream()
                .filter(com.horstmann.ch8.ex6.Main::isAlphabetic)
                .filter(word -> word.length() > 2)
                .map(com.horstmann.ch8.ex6.Main::alphabetize);
        Map<String, Integer> wordsAndLength = mapWordsWithLength(stringStream);
        SortedSet<Map.Entry<String, Integer>> sortedByLengthMap = entriesSortedByValues(wordsAndLength);
        List<String> topWords = sortedByLengthMap.stream().map(Map.Entry::getKey).limit(n).collect(Collectors.toList());
        long endDate = System.currentTimeMillis();
        System.out.printf("Found using stream in %s milliseconds\n", endDate - startDate);
        for (String word : topWords){
            System.out.println(word);
        }
        return topWords;
    }

    private static List<String> findNLongestWordsInParallel(String src, int n){
        long startDate = System.currentTimeMillis();
        List<String> words = scanFile(src);
        Stream<String> stringStream = words.parallelStream()
                .filter(com.horstmann.ch8.ex6.Main::isAlphabetic)
                .filter(word -> word.length() > 2)
                .map(com.horstmann.ch8.ex6.Main::alphabetize);
        Map<String, Integer> wordsAndLength = mapWordsWithLength(stringStream);
        SortedSet<Map.Entry<String, Integer>> sortedByLengthMap = entriesSortedByValues(wordsAndLength);
        List<String> topWords = sortedByLengthMap.parallelStream().map(Map.Entry::getKey).limit(n).collect(Collectors.toList());
        long endDate = System.currentTimeMillis();
        System.out.printf("Found using parallel stream in %s milliseconds\n", endDate - startDate);
        return topWords;
    }
}

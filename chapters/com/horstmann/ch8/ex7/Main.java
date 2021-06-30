package com.horstmann.ch8.ex7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Преобразовав содержимое файла в поток лексем, выведите список первых 100 лексем, являющихся словами в том смысле,
 * в каком они определены в предыдущем упражнении. Прочитайте содержимое файла снова и выведите список
 * из 10 наиболее часто употребляемых слов, игнорируя регистр букв.
 */
public class Main {
    public static void main(String[] args) {
        printFirstNWords(100);
        printTopNWords(10);
    }

    private static void printTopNWords(int i) {
        List<String> words = scanFile("chapters/com/horstmann/ch8/ex7/content.txt");
        Map<String, Integer> frequences = new TreeMap<>();
        words = words.stream()
                .filter(com.horstmann.ch8.ex6.Main::isAlphabetic)
                .filter(word -> word.length() > 2)
                .map(Main::deleteSyntaxSymbols).collect(Collectors.toList());
        List<String> finalWords = words;
//        frequences = words.stream().collect(Collectors.counting(String::equals));
//        frequences = words.stream().collect(Collectors.toMap(word -> word, word -> finalWords.stream()
//                        .filter(innerWord -> innerWord.equals(word)).count()));
        for (String word : words){
            if (frequences.containsKey(word)){
                frequences.put(word, frequences.get(word) + 1);
            } else {
                frequences.put(word, 1);
            }
        }
        SortedSet<Map.Entry<String, Integer>> sortedByPopularity = entriesSortedByValues(frequences);
        sortedByPopularity.stream().limit(i).forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void printFirstNWords(int i) {
        List<String> words = scanFile("chapters/com/horstmann/ch8/ex7/content.txt");
        Stream<String> wordsStream = words.stream().filter(com.horstmann.ch8.ex6.Main::isAlphabetic).limit(i);
        wordsStream.forEach(System.out::println);
    }

    public static List<String> scanFile (String path){
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        assert s != null;
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }

    private static String deleteSyntaxSymbols(String word) {
        while (word.matches("^[.,\\-?!(«\"]+[\\w\\p{IsCyrillic}]+[.,\\-?!»)\"]*$")) {
            word = word.substring(1);
        }
        while (word.matches("[\\w\\p{IsCyrillic}]+[\\.,\\-?!»)\"]+$")) {
            word = word.substring(0, word.length() - 1);
        }
        return word.toLowerCase();
    }

    public static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}

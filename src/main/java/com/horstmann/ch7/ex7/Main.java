package com.horstmann.ch7.ex7;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * Напишите программу для чтения всех слов из файла и вывода частоты, с которой каждое слово встречается в нем.
 * Воспользуйтесь для этой цели классом TreeMap<String, Integer>
 */
public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("chapters/com/horstmann/ch7/ex7/content.txt");
        Map<String, Integer> wordsFrequency = new TreeMap<>();
        try {
            InputStream fileContent = new FileInputStream(path.toFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
            String line;
            while ((line = br.readLine()) != null) {
                String[] worlsInLine = line.split("[ ,.!?—-]+");
                for (String word : worlsInLine){
                    wordsFrequency.put(word, wordsFrequency.containsKey(word) ? wordsFrequency.get(word) + 1 : 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Map.Entry<String, Integer> wordStatistics : wordsFrequency.entrySet()){
            System.out.println(wordStatistics.getKey() + ": " + wordStatistics.getValue());
        }
    }
}


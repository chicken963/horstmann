package com.horstmann.ch7.ex8;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Напишите программу для чтения всех слов из файла и вывода строк, в которых каждое слово встречается в нем.
 * Воспользуйтесь для этой цели преобразованием из символьных срок в множества.
 */
public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("chapters/com/horstmann/ch7/ex8/content.txt");
        Map<String, Set<String>> wordsInStrings = new TreeMap<>();
        try {
            InputStream fileContent = new FileInputStream(path.toFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
            String line;
            while ((line = br.readLine()) != null) {
                String[] worlsInLine = line.split("[ ,.!?—-]+");
                for (String word : worlsInLine) {
                    Set<String> stringsWhereWordExists = wordsInStrings.get(word);
                    if (stringsWhereWordExists == null) {
                        stringsWhereWordExists = new HashSet<>();
                        wordsInStrings.put(word, stringsWhereWordExists);
                    }
                    stringsWhereWordExists.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Set<String>> wordInStrings : wordsInStrings.entrySet()) {
            System.out.println(wordInStrings.getKey() + ":");
            for (String containingString : wordInStrings.getValue()){
                System.out.println("\t" + containingString);
            }
        }
    }
}

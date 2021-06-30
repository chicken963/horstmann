package com.horstmann.ch8.ex9;

import java.util.List;
import java.util.stream.Collectors;

import static com.horstmann.ch8.ex7.Main.scanFile;

/**
 * Определите среднюю длину строки в заданном конечном потоке символьных строк.
 */
public class Main {
    public static void main(String[] args) {
        List<String> words = scanFile("chapters/com/horstmann/ch8/ex9/content.txt");
        System.out.println(words.stream().collect(Collectors.summarizingInt(String::length)).getAverage());
    }
}

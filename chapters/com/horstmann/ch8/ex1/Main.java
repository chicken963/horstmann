package com.horstmann.ch8.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Убедитесь, что запрос первых пяти длинных слов не требует вызова метода
 * filter(), если найдено пятое длинное слово. С этой целью просто организуйте протоколирование вызова каждого метода.
 */
public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Владимир", "Путин", "молодец", "политик", "лидер", "и", "борец");
        List<String> longWords = words.stream()
                .filter(Main::isALongWord)
                .limit(5)
                .collect(Collectors.toList());
    }
    private static boolean isALongWord(String word){
        System.out.printf("Word '%s' is checked\n", word);
        return word.length() >= 5;
    }
}

package com.horstmann.ch7.ex11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Напишите программу для чтения предложения в списочный массив. Затем перетасуйте в массиве все слова, кроме первого и последнего, используя метод
 * Collections. shuffle (), но не копируя слова в другую коллекцию.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(shuffleInnerWords("Hi, my name is Danny, just call me Dan"));
        System.out.println(shuffleInnerWords("Hi, my name is Danny, just call me Dan"));
        System.out.println(shuffleInnerWords("Hi, my name is Danny, just call me Dan"));
        System.out.println(shuffleInnerWords("Hi, my name is Danny, just call me Dan"));
    }

    private static String shuffleInnerWords(String sentence){
        List<String> sentenceWords = Arrays.asList(sentence.split("[\\. ,;:]+"));
        Collections.shuffle(sentenceWords.subList(1, sentenceWords.size() - 1));
        StringBuilder sb = new StringBuilder();
        for (String word : sentenceWords){
            sb.append(word).append(" ");
        }
        return sb.toString();
    }
}

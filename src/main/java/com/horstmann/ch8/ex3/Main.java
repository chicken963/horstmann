package com.horstmann.ch8.ex3;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Допустим, что имеется массив int[] values = { 1, 4, 9, 16 }. Каков результат вызова Stream.of(values)?
 * Как вместо этого получить поток данных типа int?
 */
public class Main {
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        Stream defaultStream = Stream.of(values);
        IntStream intStream = Arrays.stream(values);
        defaultStream.forEach(i -> System.out.println(i));
        intStream.forEach(System.out::println);
    }
}

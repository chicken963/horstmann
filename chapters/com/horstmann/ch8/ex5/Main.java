package com.horstmann.ch8.ex5;

import java.util.stream.Stream;

/**
 * Метод letters(), упоминавшийся в разделе 8.3, выглядит несколько неуклюже, поскольку в нем сначала получается
 * списочный массив, а затем он превращается в поток данных. Напишите другой, однострочный вариант этого метода,
 * используя поток данных. Преобразуйте значения типа int в пределах от 0 до s.length() - 1 с помощью подходящего
 * лямбда-выражения.
 */
public class Main {
    public static void main(String[] args) {
        Stream<String> testStream = letters("Morgenstern");
        testStream.forEach(System.out::println);
    }
    public static Stream<String> letters(String s){
        return Stream.iterate(0, i -> i + 1).limit(s.length()).map(i -> s.substring(i, i+1));
    }
}

package com.horstmann.ch8.ex12;

import java.util.stream.Stream;

/**
 * Напишите метод public static <Т> Stream<T> zip(Stream <T> first, Stream <T> second), изменяющий элементы из потоков
 * данных first и second (или возвращающий пустое значение null, если в потоке данных, черед которого настает, исчерпываются элементы).
 * интерпретация - кладем элементы "впрочёс"
 */
public class Main {
    public static <T> Stream<T> zip(Stream <T> first, Stream <T> second){
        return Stream.concat(first, second);
    }
}

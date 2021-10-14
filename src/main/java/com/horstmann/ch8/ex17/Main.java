package com.horstmann.ch8.ex17;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    /**
     * Каким образом можно исключить получение смежных дубликатов из потока данных?
     * Сможет ли написанный вами метод обрабатывать параллельный поток?
     */
    public static void main(String[] args) {
        //при сведении зарезолвить конфликт. ему вообще всё равно, смежные или нет
        Stream<Integer> stream = Stream.generate(() -> 3).limit(100);
        System.out.println(stream.reduce((old1, new1) -> new1));
        stream = Stream.generate(() -> 3).limit(100);
        System.out.println(stream.parallel().reduce((old1, new1) -> new1));
    }

    public static Map<String, Integer> mapWordsWithLength(Stream<String> wordsStream) {
        return wordsStream.collect(Collectors.toMap(Function.identity(), String::length, (e, n) -> e));
    }
}

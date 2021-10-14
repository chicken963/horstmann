package com.horstmann.ch8.ex4;

import java.util.stream.Stream;

/**
 * С помощью метода Stream.iterate() создайте бесконечный поток случайных чисел, не вызывая метод Math.random(), а
 * непосредственно реализуя линейный конгруэнтный генератор. Такой генератор начинает действовать с числа, задаваемого
 * выражением х0 = начальное значение, а затем производит случайные числа по формуле х (n + 1) = (а хп + с) % т,
 * при соответствующих значениях а, с и т. С этой целью реализуйте метод, принимающий параметры а, с, т и получающий
 * поток данных Stream<Long>. Опробуйте его со следующими параметрами: а = 25214903917, с = 11 и т = 2^48
 */
public class Main {
    public static void main(String[] args) {
        Stream<Long> testStream = generateCongruentStream(25214903917L, 11, (long) Math.pow(2, 48));
        testStream.limit(20).forEach(System.out::println);
    }

    private static Stream<Long> generateCongruentStream(long a, long c, long m){
        return Stream.iterate(0L, n -> (a * n + c) % m);
    }
}

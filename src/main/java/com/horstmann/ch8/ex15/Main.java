package com.horstmann.ch8.ex15;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Найдите 500 простых чисел с 50 десятичными цифрами, используя параллельный поток данных типа Biglnteger
 * и метод Biglnteger.isProbablePrime().
 * Насколько это делается быстрее, чем при использовании последовательного потока данных?
 */
public class Main {
    private static final String BASE_50_SIGNS = "10000000000000000000000000000000000000000000000000";

    public static void main(String[] args) {
        long startDate = System.currentTimeMillis();
        Stream<BigInteger> first500prime50sighedIntegers = Stream
                .iterate(new BigInteger(BASE_50_SIGNS), i -> i.add(BigInteger.ONE));
        List<BigInteger> bigIntegerList = first500prime50sighedIntegers
                .filter(value -> value.isProbablePrime(1))
                .limit(500)
                .collect(Collectors.toList());
        long endDate = System.currentTimeMillis();
        System.out.printf("Found using stream in %s milliseconds\n", endDate - startDate);

        startDate = System.currentTimeMillis();
        first500prime50sighedIntegers = Stream
                .iterate(new BigInteger(BASE_50_SIGNS), i -> i.add(BigInteger.ONE));
        Stream<BigInteger> parallelStream = first500prime50sighedIntegers.parallel()
                .filter(value -> value.isProbablePrime(1))
                .limit(500);
        bigIntegerList = parallelStream.collect(Collectors.toList());
        endDate = System.currentTimeMillis();
        System.out.printf("Found using parallel stream in %s milliseconds", endDate - startDate);

//        for (BigInteger bigInteger : bigIntegerList) {
//            System.out.println(bigInteger);
//        }
    }
}

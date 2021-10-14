package com.horstmann.ch10.ex2;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Насколько большим должен быть массив, чтобы метод Arrays.parallelSort() выполнялся быстрее, чем метод
 * Arrays.sort() на вашем компьютере?
 */
public class Main {
    public static void main(String[] args) {
        //на 10к уравнивается, потом parallel побеждает
        double[] array = DoubleStream.iterate(3, e -> e += (-1 + 2 * Math.random())).limit(10000).toArray();
        printResults("Sort", calculateTimeForOperation(Arrays::sort, array));
        printResults("Parallel sort", calculateTimeForOperation(Arrays::parallelSort, array));
    }

    private static void printResults(String methodName, long timeDelta) {
        System.out.println(methodName + " took " + timeDelta + " milliseconds");
    }

    private static long calculateTimeForOperation(Consumer<double[]> callback, double[] array) {
        long startTime = System.currentTimeMillis();
        callback.accept(array);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}

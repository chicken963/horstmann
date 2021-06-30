package com.horstmann.ch8.ex14;

import java.util.stream.Stream;

/**
 * Организуйте вызов метода reduce() таким образом, чтобы вычислить среднее в потоке данных Stream<Double>.
 * Почему нельзя просто вычислить сумму и разделить ее на результат, возвращаемый методом count()?
 */
public class Main {
    private static double total = 0;
    private static int count = 0;
    public static void main(String[] args) {
        Stream<Double> stream = Stream.iterate(4.0, i -> i + 2).limit(100);
        System.out.println(
                stream.reduce((double) 0, (currentAverage, newValue) -> recalculateCurrentAverage(newValue))
        );
    }

    private static double recalculateCurrentAverage(double newElement) {
        total += newElement;
        count += 1;
        return total / count;
    }
}

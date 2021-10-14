package com.horstmann.ch3.ex5;

/**
 * Реализуйте статический метод constant() из интерфейса IntSequence, возвращающий бесконечную последовательность
 * констант. Например, в результате вызова IntSequence.constant(1) возвращается бесконечная последовательность 111....
 * В качестве дополнительного задания сделайте то же самое с помощью лямбда-выражения.
 */
public interface IntSequence {

    static IntSequence constant(int value) {
        return () -> value;
    }

    default boolean hasNext() {
        return true;
    }

    int next();

}

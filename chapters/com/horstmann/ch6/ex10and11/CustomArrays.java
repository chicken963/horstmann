package com.horstmann.ch6.ex10and11;

import com.horstmann.ch6.ex7.Pair;

/**
 * Предоставьте в служебном классе Arrays обобщенные методы min() и mах(),
 * возвращающие наименьший и наибольший элементы массива соответственно
 */
public class CustomArrays {
    public static <E extends Comparable<E>> E max(E[] array) {
        E maxValue = array[0];
        for (E elem : array) {
            if (elem.compareTo(maxValue) > 0) {
                maxValue = elem;
            }
        }
        return maxValue;
    }

    public static <E extends Comparable<E>> E min(E[] array) {
        E minValue = array[0];
        for (E elem : array) {
            if (elem.compareTo(minValue) < 0) {
                minValue = elem;
            }
        }
        return minValue;
    }

    public static <E extends Comparable<E>> Pair<E> minMax(E[] array){
        return new Pair<>(min(array), max(array));
    }
}

package com.horstmann.ch7.ex5;

import java.util.*;

/**
 * Реализуйте метод public static void swap(List<?> list, int i, int j), выполняющий перестановку элементов обычным
 * образом, когда класс, определяющий тип параметра list, реализует интерфейс RandomAccess, а иначе сводящий к минимуму
 * обход элементов на позициях, обозначаемых индексами i и j.
 */
public class Main {
    public static void swap(List<?> list, int i, int j) {
        assert list instanceof RandomAccess;
        //реализация из Arraylist
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
        //вспомогательный метод
        //swapHelper(list, i, j);
    }

    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        swap(list, 2, 3);

    }
}

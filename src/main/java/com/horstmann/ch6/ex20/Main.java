package com.horstmann.ch6.ex20;

import java.util.Arrays;

/**
 * Реализуйте следующий метод:
 * SafeVarargs public static final <T> T[] repeat(int n, T... objs)
 * Он должен возвращать массив n копий заданных объектов.
 * Имейте в виду, что для этого не потребуется объект типа Class или ссылка на конструктор,
 * поскольку наращивать количество объектов objs можно рефлексивно.
 */
public class Main {
    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) throws IllegalAccessException, NoSuchFieldException {
        T[] result = Arrays.copyOf(objs, objs.length * n);
        int j = 0;
        while (j < result.length) {
            for (T obj : objs) {
                result[j] = obj;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String[] array = repeat(6, "a", "b", "c");
        for (String elem : array) {
            System.out.println(elem);
        }
    }
}

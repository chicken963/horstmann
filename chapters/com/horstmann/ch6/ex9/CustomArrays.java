package com.horstmann.ch6.ex9;

import com.horstmann.ch6.ex7.Pair;

import java.util.ArrayList;

/**
 * Предоставьте в служебном классе Arrays следующий метод, возвращающий пару, состоящую из первого и последнего
 * элементов массива а, указав подходящий аргумент типа: public static <Е> Pair<E> firstLast(ArrayList<__> a)
 */
public class CustomArrays {
    public static <E> Pair<E> firstLast(ArrayList<? extends E> a) {
        return new Pair<>(a.get(0), a.get(a.size() - 1));
    }
}

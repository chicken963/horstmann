package com.horstmann.ch6.ex6;

import java.util.Collection;
import java.util.List;

/**
 * Реализуйте обобщенный метод, присоединяющий все элементы из одного
 * списочного массива к другому. Воспользуйтесь метасимволом подстановки для
 * обозначения одного из аргументов типа. Предоставьте два равнозначных решения:
 * одно с подстановочным типом ? extends Е, другое — с подстановочным типом ? super Е.
 */
public class Main {
    public static <E> void add(List<E> head, List<? extends E> tail){
        head.addAll(tail);
    }

//    public static <E> void add(List<? super E> head, List<E> tail){
//        head.addAll(tail);
//    }
}

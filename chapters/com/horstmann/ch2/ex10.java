package com.horstmann.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * Предоставьте в классе RandomNumbers два статических метода типа randomElement, получающих произвольный элемент из
 * обычного или списочного массива целочисленных значений. (Если обычный или списочный массив пуст, должен быть
 * возвращен нуль). Почему эти методы нельзя сделать методами экземпляра типа t[] или ArrayList<Integer>?
 */
public class ex10 {
    public static class RandomNumbers {
        public static int randomElement(int[] array) {
            int randomIndex = (int) (Math.random() * array.length);
            return array.length > 0 ? array[randomIndex] : 0;
        }

        public static int randomElement(List<Integer> list) {
            int randomIndex = (int) (Math.random() * list.size());
            return list.size() > 0 ? list.get(randomIndex) : 0;
        }
    }

    /**
     * Почему эти методы нельзя сделать методами экземпляра типа t[] или ArrayList<Integer> ?
     * Я вижу только одну причину - потому что эти типы входят в стандартную библиотеку и потому неизменяемы.
     * Заэкстендить вполне возможно.
     * @param args
     */
    public static void main(String[] args) {
        int length = 20;
        int[] array = new int[length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
//            int newElement = (int) (Math.random() * 100);
            array[i] = i;
            list.add(i);
        }
        System.out.println(RandomNumbers.randomElement(array));
        System.out.println(RandomNumbers.randomElement(list));
    }
}

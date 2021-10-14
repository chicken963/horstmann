package com.horstmann.ch6.ex8;

/**
 * Видоизмените класс из предыдущего упражнения, введя методы mах() и min() для получения наибольшего и наименьшего из
 * двух элементов. Наложите соответствующее ограничение на обобщенный тип Е.
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(23, 56);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        System.out.println(pair.max());
    }
}

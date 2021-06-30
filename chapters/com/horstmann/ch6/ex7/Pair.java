package com.horstmann.ch6.ex7;

/**
 * Реализуйте обобщенный класс Pair<E>, позволяющий сохранять пару элементов типа Е.
 * Предоставьте методы доступа для получения первого и второго элементов.
 */
public class Pair<E> {
    private E key;
    private E value;

    public Pair(E key, E value) {
        this.key = key;
        this.value = value;
    }

    public E getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}

package com.horstmann.ch6.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Еще раз реализуйте обобщенный класс Stack<E>, используя массив для хранения элементов.
 * Если требуется, нарастите массив в методе push(). Предоставьте два решения этой задачи: одно — с массивом типа Е[],
 * другое — с массивом типа Object[].
 * Оба решения должны компилироваться без всяких предупреждений. Какое из них вы предпочтете сами и почему?
 * @param <E>
 */
public class Stack<E> {
    private E[] array;

    public Stack(E[] array) {
        this.array = array;
    }

    public void push(E element) {
        ArrayList<E> bufferArray = new ArrayList<>(Arrays.asList(array));
        bufferArray.add(element);
        array = (E[]) bufferArray.toArray();
    }

    public void pop(E element) {
        List<E> bufferArray = new ArrayList<>(Arrays.asList(array));
        bufferArray.remove(element);
        array = (E[]) bufferArray.toArray();
    }

    public boolean isEmpty() {
        return array.length == 0;
    }
}

package com.horstmann.ch6.ex22;

public class Main {
    public static Integer getElement(Integer[] array, int index) {
        return array[index];
    }

    public static void main(String[] args) {
        Integer[] array = {3, 6, 7, 2};
        WorkService.doWork(()-> getElement(array, 5), IndexOutOfBoundsException.class);
    }
}

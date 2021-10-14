package com.horstmann.ch6.ex21;

import java.util.Arrays;
import java.util.List;

/**
 * Используя аннотацию SafeVarargs, напишите метод, позволяющий строить массивы обобщенных типов, как в следующем примере:
 * List<String>[] result = Arrays.<List<String>>construct (10) ;
 * // Устанавливает результат в списке типа List<String>[] длиной 10
 */
public class Main {
    public static void main(String[] args) {
        List<String>[] result = CustomArrays.<List<String>>construct(10);
        System.out.println(result.length);
    }
}

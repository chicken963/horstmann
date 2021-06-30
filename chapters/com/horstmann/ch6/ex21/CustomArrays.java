package com.horstmann.ch6.ex21;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Используя аннотацию SafeVarargs, напишите метод, позволяющий строить массивы обобщенных типов, как в следующем примере:
 * List<String>[] result = Arrays.<List<String>>construct (10) ;
 * // Устанавливает результат в списке типа List<String>[] длиной 10
 */
public class CustomArrays {
    public static <T> T[] construct(int n){
        List<T> result = new ArrayList<>(n);
        @SuppressWarnings("unchecked") T[] entries = (T[]) result.stream().toArray();
        return entries;
    }
}

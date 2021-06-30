package com.horstmann.ch6.ex5;

import java.util.Arrays;

public class CustomArrays {
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

}

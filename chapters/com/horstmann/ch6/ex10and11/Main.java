package com.horstmann.ch6.ex10and11;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {2, 7, 2, 1, -67, 53};
        System.out.println(CustomArrays.max(array));
        System.out.println(CustomArrays.min(array));
        System.out.println(CustomArrays.minMax(array).getKey() + " & " + CustomArrays.minMax(array).getValue());
    }
}

package com.horstmann.ch4.ex12;

import java.lang.reflect.InvocationTargetException;

import static com.horstmann.ch4.ex11.Main.customPrint;
/**
 * Определите отличие в производительносги обычного вызова метода от его вызова через рефлексию.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        long timeBefore = System.currentTimeMillis();
        customPrint("abc");
        long timeAfter = System.currentTimeMillis();
        long delta = timeAfter - timeBefore;
        System.out.printf("Printing via reflection took %d milliseconds\n", delta);

        timeBefore = System.currentTimeMillis();
        System.out.println("abc");
        timeAfter = System.currentTimeMillis();
        delta = timeAfter - timeBefore;
        System.out.printf("Printing directly %d milliseconds\n", delta);
    }
}

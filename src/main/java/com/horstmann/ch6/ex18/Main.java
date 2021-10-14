package com.horstmann.ch6.ex18;

import java.util.function.IntFunction;

/**
 * Рассмотрите следующий метод, представленный в разделе 6.6.3:
 * public static <Т> Т[] repeat(int n, Т obj, IntFunction<T[]> constr)
 * Почему исход вызова Arrays.repeat(10, 42, int[]::new) окажется неудачным? Как устранить этот недостаток?
 * Что нужно сделать для применения других примитивных типов?
 */
public class Main {
    public static void main(String[] args) {
        //боксинг
        RepeatService.repeat(10, 42, Integer[]::new);
    }
}

package com.horstmann.ch3.ex13;

/**
 * Напишите метод, принимающий массив экземпляров типа Runnable и возвращающий экземпляр типа Runnable, метод которого
 * run() выполняет их по порядку. Организуйте возврат лямбда-выражения.
 */
public class Runner {
    public static Runnable runInOrder(Runnable[] runnables) {
        return () -> {
            for (Runnable runnable : runnables) runnable.run();
        };
    }
}

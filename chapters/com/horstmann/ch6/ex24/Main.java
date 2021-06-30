package com.horstmann.ch6.ex24;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Какие методы можно вызвать для переменной типа Class<?> , не прибегая к приведению типов?
 * Ответ: только в конструкторах (см. реализации соотв. методов)
 */
public class Main<U> {
    public static <T> ArrayList<T> repeat(int n, Class<T> cl) throws ReflectiveOperationException {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(cl.newInstance());
        return result;
    }

    public static <T> ArrayList<? super T> repeatSuper(int n, Class<T> cl) throws ReflectiveOperationException {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add((T) cl.getSuperclass().newInstance());
        return result;
    }

    public static <T> ArrayList<? extends T> repeatSub(int n, Class<T> cl) throws ReflectiveOperationException {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(cl.asSubclass(cl).newInstance());
        return result;
    }


}

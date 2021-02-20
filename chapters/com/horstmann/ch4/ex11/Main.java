package com.horstmann.ch4.ex11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Напишите программу, выводящую сообщение "Hello, World", воспользовавшись рефлексией для поиска поля out в классе
 * java.lang.System и методом invoke() для вызова метода println().
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException,
            NoSuchFieldException,
            InvocationTargetException,
            IllegalAccessException {
        customPrint("abc");
        return;
    }

    public static void customPrint(String string) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> cl = Class.forName("java.lang.System");
        //получаем поле
        Field out = cl.getField("out");
        //а затем метод (через getType()
        Method println = out.getType().getMethod("println", String.class);
        //а вот смысл этого действия я не понял
        Object object = out.get(null);
        println.invoke(object, string);
    }
}

package com.horstmann.ch4.ex10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Воспользуйтесь примером кода из раздела 4.5.1 для перечисления всех методов из класса типа int[].
 * В качестве дополнительного задания можете выявить один метод, обсуждавшийся в этой главе, как неверно описанный.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] intArray = {};
        String className = intArray.getClass().getName();
        Class<?> cl = Class.forName(className);
        while(cl !=null)

        {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() + Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }
}

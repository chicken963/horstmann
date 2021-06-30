package com.horstmann.ch6.ex25;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Напишите метод public static String genericDeclaration(Method m), возвращающий объявление метода m(), перечисляющего
 * параметры типа с их ограничениями и типами параметров метода, включая их аргументы типа, если это обобщенные типы.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Class<?> cl = Class.forName("com.horstmann.ch6.ex25.Bicycle");
            Method println = cl.getMethod("getWheelsDiameters", List.class);
            System.out.println(genericDeclaration(println));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static String genericDeclaration(Method m) {
        String methodDescription = "name: " + m.getName() + ", return type: " + m.getReturnType().getSimpleName();
        if (m.getReturnType().getSuperclass() != null
                && m.getReturnType().getSuperclass() != Object.class) {
            methodDescription += " extends " + m.getReturnType().getSuperclass().getSimpleName();
        }
        methodDescription += ", \n";
        Class<?>[] argumentClasses = m.getParameterTypes();
        StringBuilder argumentsDescription = new StringBuilder("argument types: ");
        for (Class<?> clazz : argumentClasses) {
            String argumentDescription = clazz.getSimpleName();
            if (clazz.getSuperclass() != null
                    && clazz.getSuperclass() != Object.class) {
                argumentDescription += " extends " + clazz.getSuperclass().getSimpleName();
            }
            argumentsDescription.append(argumentDescription).append("\n");
        }
        methodDescription += argumentsDescription.toString();
        return methodDescription;
    }
}

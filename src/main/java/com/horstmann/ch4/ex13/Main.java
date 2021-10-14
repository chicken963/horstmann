package com.horstmann.ch4.ex13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

/**
 * Напишите метод, выводящий таблицу значений из любого объекта типа Method, описывающего метод с параметром типа double
 * или Double. Помимо объекта типа Method, этот метод должен принимать нижний и верхний предел, а также величину шага.
 * Продемонстрируйте свой метод, выведя таблицы для методов Math.sqrt() и Double.toHexString(). Напишите еще один
 * вариант данного метода, но на этот раз воспользуйтесь объектом типа DoubleFunction<0bject> вместо объекта типа
 * Method (см. раздел 3.6.2). Сопоставьте безопасность, эффективность и удобство обоих вариантов данного метода.
 */
public class Main {
//    private static int floor = 2;
//    private static int ceiling = 100;
//    private static int step = 15;
    public static void processDoubles(Method m,
                                      double floor,
                                      double ceiling,
                                      double step)
            throws InvocationTargetException,
            IllegalAccessException {
        if (m.getParameterCount() != 1) {
            System.out.println("Method requires more than 1 agrument");
            return;
        }
        if (!m.getParameterTypes()[0].equals(Double.class)
                && !m.getParameterTypes()[0].equals(double.class)) {
            System.out.println("Method takes argument of incompatible type (Double is required)");
            return;
        }
        if (!checkIterationArguments(floor, ceiling, step)) return;
        System.out.println("Via Invocation:\n");
        System.out.printf("%8s | %8s\n", "argument", "value");
        for (double number = floor; number < ceiling; number += step) {
            System.out.printf("%8s | %8s\n", number, m.invoke(new Object(), number));
        }
    }

    public static void processDoublesViaFunction(DoubleFunction<Object> m,
                                                 double floor,
                                                 double ceiling,
                                                 double step) {
        if (!checkIterationArguments(floor, ceiling, step)) return;
        System.out.println("Via DoubleFunction\n");
        System.out.printf("%8s | %8s\n", "argument", "value");
        for (double number = floor; number < ceiling; number += step) {
            System.out.printf("%8s | %8s\n", number, m.apply(number));
        }
    }

    private static boolean checkIterationArguments(double floor, double ceiling, double step) {
        if (ceiling < floor) {
            System.out.println("Upper limit should me greater than lower");
            return false;
        }
        if (step < 0) {
            System.out.println("Step should be positive");
            return false;
        }
        return true;
    }

    public static void measureInvokationAsMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startDate = System.currentTimeMillis();
        processDoubles(Math.class.getMethod("sqrt", double.class), 2, 100, 25);
        processDoubles(Double.class.getMethod("toHexString", double.class), 2, 100, 25);
        long endDate = System.currentTimeMillis();
        long delta = endDate - startDate;
        System.out.printf("Invocation took %d milliseconds", delta);
    };
    public static void measureInvokationAsFunction(){
        long startDate = System.currentTimeMillis();
        processDoublesViaFunction(Math::sqrt, 2, 100, 25);
        processDoublesViaFunction(Double::toHexString, 2, 100, 25);
        long endDate = System.currentTimeMillis();
        long delta = endDate - startDate;
        System.out.printf("Processing DoubleFunction took %d milliseconds\n", delta);
    };

    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException {
        measureInvokationAsMethod();
        measureInvokationAsFunction();
    }


}

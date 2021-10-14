package com.horstmann.ch5.ex12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Напишите метод int min (int[] values), в котором перед возвратом наименьшего значения утверждается, что оно
 * действительно не больше всех остальных значений в массиве. Воспользуйтесь вспомогательным методом или же методом
 * Stream.allMatch(), если вы уже просматривали материал главы 8. Организуйте повторный вызов данного метода для
 * обработки крупного массива и определите время выполнения кода при разрешении, запрете и исключении утверждений.
 */
public class Main {
    public static void main(String[] args) {
        int[] testArray = {1, 3, 4 ,6, 3};
        System.out.println(min(testArray));
    }

    public static int min(int[] values){
        Integer[] valuesAsObjects = new Integer[values.length];
        for(int index = 0; index < values.length; index++){
            valuesAsObjects[index] = values[index];
        }
        List<Integer> valuesAsList = Arrays.asList(valuesAsObjects);
        Collections.sort(valuesAsList);
        Integer minValue = valuesAsList.get(0);
        assert Arrays.stream(values).allMatch(number -> ((minValue - number) < 0));
        return minValue;
    }
}

package com.horstmann.ch6.ex12and13;

import java.util.Comparator;
import java.util.List;

/**
 * Реализуйте следующий метод, сохраняющий наименьший и наибольший элементы из массива elements в списке result:
 */
public class CustomArrays {
    public static <T> void minmax(List<T> elements,
                                  Comparator<? super T> comp, List<T> result){
        T minValue = elements.get(0);
        T maxValue = elements.get(0);
        for (T value : elements){
            if (comp.compare(minValue, value) > 0){
                minValue = value;
            } else if (comp.compare(maxValue, value) < 0){
                maxValue = value;
            }
        }
        result.add(minValue);
        result.add(maxValue);
    }

    public static <T> void swapHelper(List<T> result, int indexOne, int indexTwo){
        T temp = result.get(indexOne);
        T temp2 = result.get(indexTwo);
        result.set(indexTwo, temp);
        result.set(indexOne, temp2);
    }

}

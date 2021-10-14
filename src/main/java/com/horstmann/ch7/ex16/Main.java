package com.horstmann.ch7.ex16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * Усовершенствуйте реализацию из предыдущего упражнения, организовав кеширование последних 100 значений, вычисленных функцией.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> resultList = getIndecesUpTo(Main::getUnmodifiableList, 4);
    }

    private static List<Integer> getIndecesUpTo(IntFunction<List<Integer>> wayOfPerforming, int n){
        return Collections.unmodifiableList(wayOfPerforming.apply(n));
    }

    private static List<Integer> getUnmodifiableList(int n){
        List<Double> tempList = new ArrayList<>();
        int i = 0;
        while (i < n){
            tempList.add(Math.random());
            i++;
        }
        return Collections.unmodifiableList(tempList.stream().map(tempList::indexOf).limit(100).collect(Collectors.toList()));
    }

}

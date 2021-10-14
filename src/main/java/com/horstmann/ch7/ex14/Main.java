package com.horstmann.ch7.ex14;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Напишите метод для получения неизменяемого представления списка чисел от 0 до п, не сохраняя эти числа.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> indices = getIndecesUpTo(5);
        for(int i : indices){
            System.out.println(i);
        }
        try {
            indices.set(1, 3);
        } catch (UnsupportedOperationException e) {
            System.out.println("Attempt to modify unmodifiable...");
            e.printStackTrace();
        }
    }

    private static List<Integer> getIndecesUpTo(int n){
        List<Double> tempList = new ArrayList<>();
        int i = 0;
        while (i < n){
            tempList.add(Math.random());
            i++;
        }
        return Collections.unmodifiableList(tempList.stream().map(tempList::indexOf).collect(Collectors.toList()));
    }
}

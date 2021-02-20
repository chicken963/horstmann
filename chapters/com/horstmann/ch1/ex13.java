package com.horstmann.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите программу, выбирающую и выводящую лотерейную комбинацию из шести отдельных чисел в пределах от 1 до 49.
 * Чтобы выбрать шесть отдельных чисел, начните со списочного массива, заполняемого числами от 1 до 49.
 * Выберите произвольный индекс и удалите элемент массива. Повторите эти действия шесть раз подряд.
 * Выведите полученный результат в отсортированном порядке.
 */

public class ex13 {
    private static ArrayList<Integer> availableNumbers = new ArrayList<Integer>();
    private static ArrayList<Integer> selectedNumbers = new ArrayList<Integer>();
    private static final int numberOfNumbersToSelect = 6;

    public static void main(String[] args) {
        fillArray(50);
        int counter = 0;
        while (counter < numberOfNumbersToSelect){
            int randomIndex = (int)(Math.floor(availableNumbers.size() * Math.random()));
            int numberToSelect = availableNumbers.get(randomIndex);
            availableNumbers.remove(randomIndex);
            selectedNumbers.add(numberToSelect);
            counter++;
        }
        System.out.println(availableNumbers);
    }

    private static void fillArray(int length){
        int i = 1;
        while (i < length){
            availableNumbers.add(i);
            i++;
        }
    }
}

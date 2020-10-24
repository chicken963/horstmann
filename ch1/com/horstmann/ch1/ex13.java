package com.horstmann.ch1;

import java.util.ArrayList;

public class ex13 {
    private static ArrayList<Integer> availableNumbers = new ArrayList<>();
    private static ArrayList<Integer> selectedNumbers = new ArrayList<>();
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
        System.out.println(selectedNumbers);
    }

    private static void fillArray(int length){
        int i = 1;
        while (i < length){
            availableNumbers.add(i);
            i++;
        }
    }
}

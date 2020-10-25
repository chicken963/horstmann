package com.horstmann.ch1;

import java.util.Scanner;

/**
 * Напишите программу, вводящую символьную строку и выводящую все ее непустые подстроки.
 */
public class ex8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the string to split: ");
        String string = in.nextLine();
        splitter(string);
    }
    private static void splitter(String inputString){
       String[] splittedStrings = inputString.split("\\s+");
       for(String string: splittedStrings){
           System.out.println(string);
       }
    }
}

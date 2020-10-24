package com.horstmann.ch1;

import java.math.BigInteger;
import java.util.Scanner;

public class ex6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number to calculate factorial for: ");
        int number = in.nextInt();
        System.out.println("The answer is " + factorial(number));
    }

    private static BigInteger factorial(int n){
        int counter = 1;
        BigInteger factorial = BigInteger.valueOf(1);
        while (counter <= n){
            factorial = factorial.multiply(BigInteger.valueOf(counter));
            counter++;
        }
        return factorial;
    }
}

package com.horstmann.ch1;

import java.util.Scanner;

/**
 * Напишите программу, вводящую три целочисленных значения и выводящую самое большое из них, используя только условную
 * операцию. Сделайте то же самое с помощью метода Math.шах ().
 */
public class ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the first number: ");
        int number1 = in.nextInt();

        System.out.print("Please enter the second number: ");
        int number2 = in.nextInt();

        System.out.print("Please enter the third number: ");
        int number3 = in.nextInt();

        if (number1 == number2 || number1 == number3 || number2 == number3){
            System.out.println("There is no maximum");
        } else if (number1 > number2 && number1 > number3){
            System.out.printf("The maximum is %d", number1);
        } else if (number2 > number1 && number2 > number3){
            System.out.printf("The maximum is %d", number2);
        } else {
            System.out.printf("The maximum is %d", number3);
        }
        System.out.println(Math.max((Math.max(number1, number2)), number3));
    }
}

package com.horstmann.ch1;
import java.util.Scanner;

/**
 * Напишите программу, вводящую целочисленное значение и выводящую его в двоичной, восьмеричной и шестнадцатеричной
 * форме. Организуйте вывод обратного значения в виде шестнадцатеричного числа с плавающей точкой.
 */
public class ex1 {

    public static void main(String[]args){
        System.out.print("Please enter your number: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        double flipped = 1.0/number;
        System.out.printf("Hexadecimal representation: %x\n", number);
        System.out.printf("Octal representation: %o\n", number);
        System.out.println("Binary representation: " + Integer.toBinaryString(number) + "\n162");
        System.out.printf("Floating representation of a flipped number: %.5a\n", flipped);
    }
}

package com.horstmann.ch1;

import java.util.Scanner;

/**
 * Напишите программу, вводящую два числа в пределах от 0 до 65535, сохраняющую их в переменных типа short и
 * вычисляющую их сумму, разность, произведение, частное и остаток без знака, не преобразуя эти величины в тип int.
 */
public class ex7 {
    private static final short delta = -32768;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the first number less than 65536: ");
        short number1 = in.nextShort();
        System.out.print("Please enter the second number less than 65536: ");
        short number2 = in.nextShort();
        System.out.println("Summ is " + summ(number1, number2));
        System.out.println("Difference is " + diff(number1, number2));
        System.out.println("Multiplication is " + mult(number1, number2));
        System.out.println("Division is " + divide(number1, number2));
        System.out.println("Mod is " + mod(number1, number2));
    }

    private static short summ (short a, short b){
        a += delta;
        b += delta;
        return (short) (a + b);
    }
    private static short diff (short a, short b){
        return (short) (a - b);
    }

    private static short mult (short a, short b){
        return (short) (a * b);
    }

    private static short divide (short a, short b){
        return (short) (a / b);
    }

    private static short mod (short a, short b){
        return (short) ((a % b + b) % b);
    }
}

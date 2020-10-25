package com.horstmann.ch1;

/**
 * Напишите программу, выводящую наименьшее и наибольшее положительные значения типа double.
 * Подсказка: воспользуйтесь методом Math.nextUp () из прикладного программного интерфейса Java API.
 */
public class ex4 {
    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        System.out.println(Math.nextUp(a));
        System.out.println(Math.nextUp(b/0));
    }
}

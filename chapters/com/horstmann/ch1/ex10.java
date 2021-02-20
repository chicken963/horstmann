package com.horstmann.ch1;

import java.util.Scanner;

/**
 * Напишите программу, составляющую произвольную символьную строку из букв и цифр, генерируя произвольное значение типа
 * long и выводя его по основанию 36.
 */

public class ex10 {

    static final String SYMBOLS_POOL = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static char[] charSequence;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the desired length: ");
        int length = in.nextInt();
        String randomString = randomString(length);
        System.out.println(randomString);
        long stringAs36 = parseLongAs36(randomString);
        System.out.println(stringAs36);
    }

    private static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        generateCharSequence(len);
        for (char s : charSequence)
            sb.append(s);
        return sb.toString();
    }

    private static void generateCharSequence(int length) {
        char[] result = new char[length];
        int i = 0;
        while (i < length) {
            result[i] = generateRandomChar();
            i++;
        }
        charSequence = result;
    }

    private static char generateRandomChar() {
        return SYMBOLS_POOL.charAt((int) Math.floor(SYMBOLS_POOL.length() * Math.random()));
    }

    private static long parseLongAs36(String numberAsString) {
        long result = 0;
        int counter = 0;
        for (char s : charSequence) {
            result += Math.pow(36, (numberAsString.length() - counter)) * SYMBOLS_POOL.indexOf(s);
            counter++;
        }
        return result;
    }
}

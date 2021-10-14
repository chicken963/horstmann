package com.horstmann.ch1;

import java.util.Scanner;

/**
 * Напишите программу, вводящую текстовую строку и выводящую все символы, не представленные в коде ASCII, вместе с их
 * значениями в Юникоде.
 */

class ex11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the string to split: ");
        String string = in.nextLine();
        char[] chars = string.toCharArray();
        for(char c: chars){
            if((int) c > 255){
                System.out.printf("The out-of-ascii symbol is %s, its unicode is \\u%04x\n", c, (int) c);
            }
        }
    }
}

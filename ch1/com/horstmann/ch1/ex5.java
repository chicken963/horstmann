package com.horstmann.ch1;

public class ex5 {

    public static void main(String[] args) {
        double mult = Math.floor(1 + Math.random() * 2);
        int attemptNumber = 0;
        while (attemptNumber < 10){
            double a = mult * Integer.MAX_VALUE;
            //получается потолок для Integer 2147483647
            System.out.println((int) a);
            attemptNumber++;
        }
    }
}

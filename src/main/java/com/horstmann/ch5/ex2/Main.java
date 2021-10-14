package com.horstmann.ch5.ex2;

import com.horstmann.ch5.ex1.FileReader;

import java.io.IOException;

/**
 * Напишите метод public double sumOfValues (String filename) throws..., вызывающий метод из предыдущего упражнения и
 * возвращающий сумму значений в файле. Организуйте распространение любых исключений вызывающему коду.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader();
        reader.sumOfValues("numbers.txt");
    }
}

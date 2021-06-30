package com.horstmann.ch5.ex1;

import java.io.File;
import java.io.IOException;

/**
 * Напишите метод public ArrayList<Double> readValues (String filename) throws ..., читающий числа с плавающей точкой
 * из файла. Сгенерируйте подходящие исключения, если файл не удается открыть или же если введены данные,
 * не относящиеся к числам с плавающей точкой.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader();
        reader.sumOfValues("number1s.txt");
    }
}

package com.horstmann.ch5.ex3;

import com.horstmann.ch5.ex1.FileReader;

import java.io.IOException;
import java.util.List;

/**
 * Напишите программу, вызывающую метод из предыдущего упражнения и выводящую полученный результат. Организуйте перехват
 * исключений и предоставьте ответную реакцию на действия пользователя в виде сообщений о любых ошибочных условиях.
 */
public class Main {
    public static void main(String[] args)  {
        FileReader reader = new FileReader();
        String filename = "numbers.txt";

            reader.sumOfValues(filename);

    }
}

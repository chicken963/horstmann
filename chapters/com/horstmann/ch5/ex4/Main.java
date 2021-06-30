package com.horstmann.ch5.ex4;

import com.horstmann.ch5.ex1.FileReader;

import java.io.IOException;

/**
 * Повторите предыдущее упражнение, но на этот раз не пользуйтесь исключениями. Вместо этого организуйте возврат кодов
 * ошибок из методов readValues() и sumOfValues().
 */
public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        String filename = "numbers.txt";

            reader.sumOfValues(filename);

    }

}

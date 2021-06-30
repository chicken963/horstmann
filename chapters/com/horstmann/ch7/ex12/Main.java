package com.horstmann.ch7.ex12;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Используя метод Collections.shuffle(), напишите программу для чтения предложения, перетасовки его слов и вывода
 * результата. Устраните (до и после перетасовки) написание начального слова с заглавной буквы и наличие точки в
 * конце предложения. Подсказка: не перетасовывайте при этом слова.
 */
public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("chapters/com/horstmann/ch7/ex12/content.txt");
        InputStream fileContent = null;
        try {
            fileContent = new FileInputStream(path.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
        String line = null;
        try {
            line = br.readLine();
            line = decapitalize(line);
            line = removePoint(line);
            List<String> worlsInLine = Arrays.asList(line.split("[ ]+"));
            Collections.shuffle(worlsInLine);
            line = String.join(" ", worlsInLine);
            line = decapitalize(line);
            line = removePoint(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(line);
    }

    private static String removePoint(String line) {
        if(line.endsWith(".")){
            line = line.substring(0, line.length() - 1);
        }
        return line;
    }

    private static String decapitalize(String line){
        String firstLetter = line.substring(0, 1);
        firstLetter = firstLetter.toLowerCase();
        return firstLetter + line.substring(1);
    }
}

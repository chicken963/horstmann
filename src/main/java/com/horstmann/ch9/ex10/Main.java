package com.horstmann.ch9.ex10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Используя регулярное выражение, извлеките все десятичные целые числа (в том числе и отрицательные) из символьной
 * строки в списочный массив типа ArrayList<Integer>, используя, во-первых, метод find(), а во-вторых — метод split().
 * Имейте в виду, что знак + или -, после которого не следует цифра, является разделителем.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> foundIntegers = new ArrayList<>();
        String sourceString = Files.lines(Paths.get("chapters/com/horstmann/ch9/ex10/content.txt"))
                .findFirst()
                .orElse("");
        Pattern pattern = Pattern.compile("([\\+\\-]?)(\\d+)");
        Matcher matcher = pattern.matcher(sourceString);
        while (matcher.find()){
            foundIntegers.add(Integer.parseInt(matcher.group()));
        }
        for(int number : foundIntegers) {
            System.out.println(number);
        }
    }
}

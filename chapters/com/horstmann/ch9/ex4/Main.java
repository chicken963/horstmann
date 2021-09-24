package com.horstmann.ch9.ex4;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Supplier;

import static com.horstmann.ch4.ex11.Main.customPrint;

/**
 * Пользоваться классом Scanner удобно, но он действует чуть медленнее, чем класс BufferedReader. Организуйте построчное
 * чтение длинного файла, подсчитывая количество вводимых строк,
 * во-первых, с помощью класса Scanner и методов hasNextLine() и nextLine();
 * во-вторых, с помощью класса BufferedReader и метода readLines();
 * а в-третьих, с помощью класса BufferedReader и метода lines().
 * Каким из способов читать из файла быстрее и удобнее всего?
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path sourcepath = Paths.get("chapters/com/horstmann/ch9/ex4/content.txt");
        countExecutionTime(() -> readViaScanner(sourcepath));
        countExecutionTime(() -> readViaReadLines(sourcepath));
        countExecutionTime(() -> readViaLines(sourcepath));
    }

    private static void countExecutionTime(Supplier<String> function) {
        long timeBefore = System.currentTimeMillis();
        String targetResult = function.get();
        long timeAfter = System.currentTimeMillis();
        long delta = timeAfter - timeBefore;
        System.out.printf(targetResult + " took %d milliseconds\n", delta);
    }

    private static String readViaScanner(Path sourcePath) {
        Scanner in = null;
        try {
            in = new Scanner(sourcePath, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfLines = 0;
        assert in != null;
        while (in.hasNextLine()) {
            numberOfLines++;
            in.nextLine();
        }
        ;
        return "Via scanner: " + numberOfLines + " lines";
    }

    private static String readViaReadLines(Path sourcePath) {
        int numberOfLines = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(String.valueOf(sourcePath))))) {
            while (reader.readLine() != null){
                numberOfLines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Via readLine: " + numberOfLines + " lines";
    }

    private static String readViaLines(Path sourcePath) {
        int numberOfLines = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(String.valueOf(sourcePath))))) {
           numberOfLines = (int) reader.lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Via readLine: " + numberOfLines + " lines";
    }
}

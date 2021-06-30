package com.horstmann.ch5.ex5;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FolderService {
//    public ArrayList<Double> readDoubles(String filename) throws IOException {
//        ArrayList<Double> numbers = new ArrayList<>();
//        Scanner in = new Scanner(Paths.get(getCurrentClassDirectory() + filename));
//        while (in.hasNext()) {
//            Double number = in.nextDouble();
//            System.out.println(number);
//            numbers.add(number);
//        }
//        return numbers;
//    }

    public String getCurrentClassDirectory() {
        int extensionLength = 6;
        String className = getClass().getSimpleName();
        String pathOfClass = getClass().getResource(className + ".class").getPath();
        return pathOfClass.substring(1, pathOfClass.length() - className.length() - extensionLength);
    }
}

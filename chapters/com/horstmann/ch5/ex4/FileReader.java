//package com.horstmann.ch5.ex4;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class FileReader {
//    public ArrayList<Double> readDoubles(String filename) {
//        ArrayList<Double> numbers = new ArrayList<>();
//        Scanner in = null;
//        try {
//            in = new Scanner(Paths.get(getCurrentClassDirectory() + filename));
//            while (in.hasNext()) {
//                Double number = in.nextDouble();
//                System.out.println(number);
//                numbers.add(number);
//            }
//            return numbers;
//        } return new ArrayList<>(-1);
//
//    }
//
//    private String getCurrentClassDirectory() {
//        int extensionLength = 6;
//        String className = getClass().getSimpleName();
//        String pathOfClass = getClass().getResource(className + ".class").getPath();
//        return pathOfClass.substring(1, pathOfClass.length() - className.length() - extensionLength);
//    }
//
//    //для 2, 3 и 4 задания
//    public double sumOfValues(String filename) {
//        List<Double> valuesInFile = this.readDoubles(filename);
//        double sum = 0;
//        for (Double aDouble : valuesInFile) {
//            sum += aDouble;
//        }
//        System.out.println(sum);
//        return sum;
//    }
//}

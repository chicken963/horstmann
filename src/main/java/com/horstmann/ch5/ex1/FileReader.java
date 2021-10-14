package com.horstmann.ch5.ex1;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<Double> readDoubles(String filename) {
        List<Double> numbers = new ArrayList<>();
        Scanner in;
        try{
            in = new Scanner(Paths.get(getCurrentClassDirectory() + filename));
        } catch (IOException e){
           return Collections.singletonList(Double.parseDouble("-1"));
        }

        while (in.hasNext()) {
            Double number = in.nextDouble();
            System.out.println(number);
            numbers.add(number);
        }
        return numbers;
    }

    private String getCurrentClassDirectory() {
        int extensionLength = 6;
        String className = getClass().getSimpleName();
        String pathOfClass = getClass().getResource(className + ".class").getPath();
        return pathOfClass.substring(1, pathOfClass.length() - className.length() - extensionLength);
    }

    //для 2, 3 и 4 задания
    public double sumOfValues(String filename)  {
        List<Double> valuesInFile = null;
            valuesInFile = this.readDoubles(filename);
       if (valuesInFile.equals(Double.parseDouble("-1"))){
           System.out.println("Code -1");
           return 0;
       }
        double sum = 0;
        for (Double aDouble : valuesInFile) {
            sum += aDouble;
        }
        System.out.println(sum);
        return sum;
    }
}

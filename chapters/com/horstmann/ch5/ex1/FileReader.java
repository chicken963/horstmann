package com.horstmann.ch5.ex1;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public ArrayList<Double> readDoubles(String filename) {
        ArrayList<Double> numbers = new ArrayList<>();
        try (Scanner in = new Scanner(Paths.get(filename))) {
            while (in.hasNext()){
                Double number = in.nextDouble();
                System.out.println(number);
                numbers.add(number);
            }
        } catch (IOException e){
            System.out.println("Problems with reading from the file");
            e.printStackTrace();
        }
        return numbers;
    }
}

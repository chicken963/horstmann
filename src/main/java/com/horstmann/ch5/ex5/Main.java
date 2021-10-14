package com.horstmann.ch5.ex5;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Реализуйте метод, содержащий код, где применяются классы Scanner и PrintWriter (см. раздел 5.1.5). Но вместо
 * оператора try с ресурсами воспользуйтесь оператором catch. Непременно закройте оба объекта, при условии, что они
 * построены надлежащим образом. Для этого вам придется принять во внимание следующие условия.
 * • Конструктор класса Scanner генерирует исключение.
 * • Конструктор класса PrintWriter генерирует исключение.
 * • Метод hasNext(), next() или println() генерирует исключение.
 * • Метод out.close() генерирует исключение.
 * • Метод in.close() генерирует исключение.
 */
public class Main {
    public static void main(String[] args) {
        //готовим данные для выходного потока
        ArrayList<String> lines = new ArrayList<>();
        lines.add("a");
        lines.add("b");
        lines.add("c");
        PrintWriter out = null;
        Scanner in = null;
        //а это для входного
        FolderService folderService = new FolderService();
        String filename = "numbers.txt";
        try {
            out = new PrintWriter("output.txt");
            in = new Scanner(Paths.get(folderService.getCurrentClassDirectory() + filename));
            //выводим данные
            for (String line : lines) {
                out.println(line.toLowerCase());
            }
            //считываем данные
            while (in.hasNext()) {
                Double number = in.nextDouble();
                System.out.println(number);
            }
        } catch (Exception e) {
            //какой вариант лучше выбрать?
                try{
                    out.close();
                } catch (Exception ex){
                    e.addSuppressed(ex);
                }
            if (in != null) {
                in.close();
            }
        }
    }
}

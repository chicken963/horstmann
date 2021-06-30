package com.horstmann.ch8.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.horstmann.ch4.ex11.Main.customPrint;

/**
 * Определите разность во времени подсчета длинных слов с помощью методов parallelStream() и stream().
 * Вызовите метод System.currentTimeMillis() до и после этих методов и выведите разность. Если у вас быстродействующий
 * компьютер, выберите для подсчета длинных слов более длинный документ (например, роман "Война и мир").
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("chapters/com/horstmann/ch8/ex2/content.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        long timeBefore = System.currentTimeMillis();
        List<String> longWords = list.stream().filter(word -> word.length() >= 5).collect(Collectors.toList());
        long timeAfter = System.currentTimeMillis();
        long delta = timeAfter - timeBefore;
        System.out.printf("Filtering via stream took %d milliseconds\n", delta);

        timeBefore = System.currentTimeMillis();
        longWords = list.parallelStream().filter(word -> word.length() >= 5).unordered().collect(Collectors.toList());
        timeAfter = System.currentTimeMillis();
        delta = timeAfter - timeBefore;
        System.out.printf("Filtering via parallel stream took %d milliseconds\n", delta);

    }

}

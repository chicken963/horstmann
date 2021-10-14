package com.horstmann.ch3.ex9;

import com.horstmann.ch3.ex8.Greeter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализуйте следующие методы:
 * public static void runTogether(Runnable... tasks)
 * public static void runlnOrder(Runnable... tasks)
 * Первый метод должен выполнять каждую задачу в отдельном потоке и возвращать полученный результат,
 * а второй метод — все методы в текущем потоке и возвращать полученный результат по завершении последнего метода.
 */
public class Ex9 {
    public static void runTogether(Runnable... tasks) {
        for (Runnable r : tasks) {
            new Thread(r).start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for(Runnable task : tasks){
            task.run();
        }
    }

    private static Runnable[] prepareRunnableQueue() {
        Map<String, Integer> sayHello = new HashMap<>();
        sayHello.put("James", 2);
        sayHello.put("Evan", 4);
        sayHello.put("Norton", 3);
        Runnable[] tasks = new Greeter[sayHello.size()];

        int i = 0;
        for (String name : sayHello.keySet()) {
            tasks[i] = new Greeter(name, sayHello.get(name));
            i++;
        }
        return tasks;
    }

    public static void main(String[] args) {
        Runnable[] tasks = prepareRunnableQueue();
//        runTogether(tasks);
        runInOrder(tasks);
    }
}

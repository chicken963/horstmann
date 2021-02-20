package com.horstmann.ch3.ex13;

public class Main {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println("I'm first");
        };
        Runnable task2 = () -> {
            System.out.println("I'm second");
        };
        Runnable task3 = () -> {
            System.out.println("I'm third");
        };
        Runnable[] runnables = {task1, task2, task3};
        Runner.runInOrder(runnables).run();
    }
}

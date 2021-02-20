package com.horstmann.ch3.ex8;

/**
 * Создайте класс Greeter, реализующий интерфейс Runnable, метод которого run() выводит п раз сообщение
 * " Hello, " + target, где п и target — параметры, устанавливаемые в конструкторе. Получите два экземпляра
 * этого класса с разными сообщениями и выполните их параллельно в двух потоках.
 */
public class Greeter implements Runnable {
    private int n;
    private String target;

    public Greeter(String target, int n) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < this.n) {
            System.out.println("Hello, " + this.target);
            counter++;
        }
    }
}

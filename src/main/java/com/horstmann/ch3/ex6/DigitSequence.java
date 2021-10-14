package com.horstmann.ch3.ex6;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * В этом упражнении вам предстоит выяснить, что произойдет, если ввести метод в интерфейс. В версии Java 7 создайте
 * класс DigitSequence, реализующий интерфейс Iterator<Integer>, а не IntSequence. Предоставьте методы hasNext(), next()
 * и ничего не делающий метод remove(). Напишите программу, выводящую элементы интерфейса. В версии Java 8 интерфейс
 * Iterator был дополнен методом forEachRemaining(). Будет ли ваш код по-прежнему компилироваться при переходе к версии
 * Java 8? Если вы введете свой класс в архивный JAR-файл, не перекомпилировав его, будет ли он нормально действовать
 * в версии Java 8? Что произойдет, если вызвать метод forEachRemaining()? Кроме того, метод remove() стал методом по
 * умолчанию в версии Java 8, генерируя исключение типа UnsupportedOperationException. Что произойдет, если вы вызовете
 * метод remove() для экземпляра своего класса?
 */
public class DigitSequence implements Iterator<Integer> {
    private int[] args;

    public DigitSequence(int... args) {
        this.args = args;
    }

    @Override
    public boolean hasNext() {
        return args.length > 0;
    }

    @Override
    public Integer next() {
        int next = this.args[0];
        int[] argsSnaphot = new int[this.args.length - 1];
        System.arraycopy(args, 1, argsSnaphot, 0, this.args.length - 1);
        this.args = argsSnaphot;
        return next;
    }


    /**
     * Будет ли ваш код по-прежнему компилироваться при переходе к версии Java 8?
     * Будет, так как у forEachRemaining есть дефолтная реализация
     * @param args args
     */
    public static void main(String[] args) {
        Iterator<Integer> iterator = new DigitSequence(3, 5, 6);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*
         * Что произойдет, если вы вызовете метод remove() для экземпляра своего класса?
         * как оказалось, ничего
         */
        iterator.remove();
        /*
        Что произойдет, если вызвать метод forEachRemaining()?
        Как ни странно, компилится
         */
        iterator.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

}

package com.horstmann.ch2;

import org.omg.CORBA.IntHolder;

/**
 * Почему в Java нельзя реализовать метод, меняющий местами содержимое двух переменных типа int?
 * Потому что int это примитив, с названием переменной жестко связаны ячейки в памяти. Можно записать в эти ячейки
 * значение другого примитива, но твои к этому времени уже потрутся. Хотя если честно, вопрос не до конца понятен,
 * я же могу создать буферную переменную.
 */
public class ex4 {

    public static void main(String[] args) {

        IntHolder a = new IntHolder(97);
        IntHolder b = new IntHolder(48);
        System.out.printf("IntHolders:\na = %d, b = %d \n", a.value, b.value);

        IntHolder c;
        c = a;
        a = b;
        b = c;
        System.out.printf("a = %d, b = %d \n", a.value, b.value);

        Integer m = 21;
        Integer n = 543;

        System.out.printf("Integers:\nm = %d, n = %d \n", m, n);

        Integer k;
        k = m;
        m = n;
        n = k;
        System.out.printf("m = %d, n = %d \n", m, n);
    }
}

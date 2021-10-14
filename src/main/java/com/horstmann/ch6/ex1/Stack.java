package com.horstmann.ch6.ex1;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> list;

    public Stack(ArrayList<E> list) {
        this.list = list;
    }

    public void push(E element) {
        list.add(element);
    }

    public void pop(E element) {
        list.remove(element);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

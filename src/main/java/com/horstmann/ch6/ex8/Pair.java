package com.horstmann.ch6.ex8;

public class Pair<E extends Comparable<E>> {
    private E key;
    private E value;

    public Pair(E key, E value) {
        this.key = key;
        this.value = value;
    }

    public E getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    public E max(){
        return key.compareTo(value) > 0 ? key : value;
    }

    public E min(){
        return key.compareTo(value) < 0 ? key : value;
    }
}

package com.horstmann.ch6.ex2;

import java.util.ArrayList;
import java.util.Arrays;

public class StackObject {
    private Object[] array;

    public StackObject(Object[] array) {
        this.array = array;
    }

    public void push(Object element) {
        ArrayList<Object> bufferArray = new ArrayList<>(Arrays.asList(array));
        bufferArray.add(element);
        array = bufferArray.toArray();
    }

    public void pop(Object element) {
        ArrayList<Object> bufferArray = new ArrayList<>(Arrays.asList(array));
        bufferArray.remove(element);
        array = bufferArray.toArray();
    }

    public boolean isEmpty() {
        return array.length == 0;
    }
}

package com.horstmann.ch6.ex9;


import com.horstmann.ch6.ex7.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Pair<Integer> pair = CustomArrays.firstLast(list);
        System.out.println("first: " + pair.getKey() + ", last: " + pair.getValue());
    }
}

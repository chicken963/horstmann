package com.horstmann.ch6.ex1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("Einz");
        list.add("Zwei");
        list.add("Drei");
        list.add("Vier");
        Stack<String> stack = new Stack(list);
        stack.push("Sechs");
        stack.pop("Zwei");
        for (String elem : list){
            System.out.println(elem);
        }
        System.out.println(stack.isEmpty());
    }
}

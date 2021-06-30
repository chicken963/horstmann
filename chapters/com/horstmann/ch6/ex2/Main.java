package com.horstmann.ch6.ex2;

public class Main {
    public static void main(String[] args) {
        String[] array = {"Einz", "Zwei", "Drei", "Vier"};
        Stack<String> stack = new Stack(array);
        stack.push("Sechs");
        stack.pop("Zwei");
        for (String elem : array){
            System.out.println(elem);
        }
        System.out.println(stack.isEmpty());
    }

}

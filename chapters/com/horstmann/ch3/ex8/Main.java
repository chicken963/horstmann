package com.horstmann.ch3.ex8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Main{

    public static void main(String[] args) {
        Map<String, Integer> sayHello = new LinkedHashMap<>();
        sayHello.put("James", 16);
        sayHello.put("Evan", 4);
        sayHello.put("Norton", 8);
        for(String name: sayHello.keySet()){
            Runnable r = new Greeter(name, sayHello.get(name));
            new Thread(r).start();
        }
    }
}

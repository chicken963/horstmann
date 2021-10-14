package com.horstmann.ch6.ex19;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = RepeatService.repeat(12, "abc");
        for(String item : RepeatService.getArray(list)){
            System.out.println(item);
        }
    }
}

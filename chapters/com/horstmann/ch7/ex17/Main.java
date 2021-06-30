package com.horstmann.ch7.ex17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Покажите, каким образом проверяемое представление может сообщить о конкретной ошибке, ставшей причиной загрязнения "кучи"
 */
public class Main {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        List<House> houses = new ArrayList(){{
            add(new House(3));
            add("new House(5)");
            add(new House(7));
        }};
//        for(House h : houses){
//            System.out.println(h.getNumber());
//        }

        List<House> houses2 =
                Collections.checkedList(houses, House.class);
    }
}

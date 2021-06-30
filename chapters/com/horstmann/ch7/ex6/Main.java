package com.horstmann.ch7.ex6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * В этой главе рекомендовалось пользоваться интерфейсами вместо конкретных классов структур данных, например,
 * интерфейсом Мар вместо класса ТгееМар. К сожалению, подобная рекомендация не идет дальше этого.
 * Почему нельзя, например, воспользоваться интерфейсом Map<String, Set<Integer>>, чтобы представить содержание документа?
 * (Подсказка: как инициализировать его?) Каким типом структуры данных можно вместо этого воспользоваться?
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Set<Integer>> map = prepateMap();
        //объявить как бы можно, но Java всё равно будет помнить бэкграунд и мапы, и сета
    }

    private static Map<String, Set<Integer>> prepateMap(){
        return Collections.singletonMap("key", prepareSet());
    }

    private static Set<Integer> prepareSet() {
        Map<Integer, Integer> squares = new HashMap<>();
        squares.put(2, 4);
        squares.put(3, 9);
        squares.put(4, 16);
        return squares.keySet();
    }
}

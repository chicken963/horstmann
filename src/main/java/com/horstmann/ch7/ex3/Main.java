package com.horstmann.ch7.ex3;

import java.util.*;

/**
 * Как вычислить объединение, пересечение и разность двух множеств, используя только методы из интерфейса Set, но не организуя циклы?
 */
public class Main {
    public static void main(String[] args) {
        List<Set<Integer>> sets = prepareSets();
        sets.get(0).addAll(sets.get(1));
        printSetContent("Merge:", sets.get(0));

        sets = prepareSets();
        sets.get(0).retainAll(sets.get(1));
        printSetContent("Intersection:", sets.get(0));

        sets = prepareSets();
        sets.get(0).removeAll(sets.get(1));
        printSetContent("Delta:", sets.get(0));
    }
    private static <T> void printSetContent(String message, Set<T> set){
        System.out.println(message);
        for(T elem : set){
            System.out.println(elem.toString());
        }
        System.out.println("");
    }

    private static List<Set<Integer>> prepareSets(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(2);
        set2.add(3);
        return Arrays.asList(set1, set2);
    }
}

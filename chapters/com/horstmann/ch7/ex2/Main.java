package com.horstmann.ch7.ex2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Сделайте все буквы прописными в символьных строках, содержащихся в массиве.
 * С этой целью воспользуйтесь сначала итератором, затем перебором индексных значений в цикле и, наконец, методом replaceAll ().
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {"abc", "def", "ght"};
        capitalizeViaIteratior(strings);
        capitalizeViaIndexes(strings);
        capitalizeViaReplaceAll(strings);
    }

    private static void capitalizeViaIteratior(String[] strings) {
        List<String> stringsAsList = Arrays.asList(strings);
        Iterator<String> it = stringsAsList.listIterator();
        while (it.hasNext()){
            String elem = it.next();
            stringsAsList.set(stringsAsList.indexOf(elem), elem.toUpperCase());
        }
        printStringList(stringsAsList);
    }

    private static void capitalizeViaIndexes(String[] strings) {
        for(int i = 0; i < strings.length; i++){
            strings[i] = strings[i].toUpperCase();
        }
        printStringList(Arrays.asList(strings));
    }

    private static void capitalizeViaReplaceAll(String[] strings) {
        List<String> stringsAsList = Arrays.asList(strings);
        stringsAsList.replaceAll(String::toUpperCase);
        printStringList(stringsAsList);
    }

    private static void printStringList(List<String> list){
        for(String elem : list){
            System.out.println(elem);
        }
    }
}

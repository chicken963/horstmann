package com.horstmann.ch3.ex7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Comparator<String> comparator = new StringComparator();
        ArrayList<String> stringsToSort = new ArrayList<>();
        stringsToSort.add("abc");
        stringsToSort.add("abcd");
        stringsToSort.add("abcde");
        StringSequence.luckySort(stringsToSort, comparator);
    }
}

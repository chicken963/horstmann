package com.horstmann.ch8.ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.collections4.ListUtils;

/**
 * Соедините все элементы в потоках данных Stream<ArrayList<T>> и ArrayList<T>.
 * Покажите, как добиться этого с помощью каждой из трех форм метода reduce().
 */
public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 =  Arrays.asList("d", "e", "f");
        List<String> list3 = Arrays.asList("g", "h", "i");
        List<List<String>> listOfLists = Arrays.asList(list1, list2, list3);
        Stream<List<String>> stream = listOfLists.stream();
        List<String> concat1 = stream.reduce(ListUtils::union).orElseGet(ArrayList::new);
        stream = listOfLists.stream();
        List<String> concat2 = stream.reduce(new ArrayList<>(), (s1, s2) -> ListUtils.union(s1, s2));
        stream = listOfLists.stream();
        List<String> concat3 = stream.reduce(new ArrayList<>(), (s1, s2) -> (ArrayList<String>) ListUtils.union(s1, s2), (s1, s2) -> s1);

    }
}

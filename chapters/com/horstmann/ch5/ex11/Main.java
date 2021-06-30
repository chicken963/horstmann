package com.horstmann.ch5.ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Сравните вызов Objects.requireNonNull(obj) с утверждением assert obj != null.
 * Приведите убедительные примеры применения того и другого.
 */
public class Main {
    //requireNotNull хотя бы сообщение выдает, ну и крашится с меньшим стеком
    //не надо бегать с флагом -ea
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        System.out.println(checkListViaRequire(list));
        System.out.println(checkListViaAssert(list));
        //assert компилятор сразу спалил
    }

    private static long checkListViaRequire(List<Integer> list) {
        long startDate = System.currentTimeMillis();
        for (Integer i : list) {
            Objects.requireNonNull(i);
        }
        long endDate = System.currentTimeMillis();
        return endDate - startDate;
    }

    private static long checkListViaAssert(List<Integer> list) {
        long startDate = System.currentTimeMillis();
        for (Integer i : list) {
            assert  i != null;
        }
        long endDate = System.currentTimeMillis();
        return endDate - startDate;
    }
}

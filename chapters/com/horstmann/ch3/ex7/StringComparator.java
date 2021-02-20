package com.horstmann.ch3.ex7;

import java.util.Comparator;

public class StringComparator implements Comparator {
    /**
     * просто пример компаратора - в данном случае сотрирует по длине
     * @param o1 o1
     * @param o2 o2
     * @return int
     */
    @Override
    public int compare(Object o1, Object o2) {
        return ((String) o1).length() - ((String) o2).length();
    }
}

package com.horstmann.ch6.ex16;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Analyzer<T> {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
    }

    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) {
        return null;
    }
}

package com.horstmann.ch6.ex19;

import java.util.ArrayList;
import java.util.List;

public class RepeatService {
    public static <T> ArrayList<T> repeat(int n, T obj){
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(obj);
        return result;
    }

    public static <T> T[] getArray(List<T> list){
//        T[];
        return (T[]) list.toArray();
    }
}

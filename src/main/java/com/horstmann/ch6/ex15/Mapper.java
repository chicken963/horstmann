package com.horstmann.ch6.ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Реализуйте метод mар() , получающий списочный массив и объект типа Function <T, R> (см. главу 3) и возвращающий
 * списочный массив, состоящий из результатов применения функции к заданным элементам этого массива.
 */
public class Mapper<T, R> {
//    public List<R> map(List<T> list, Function<T, R> function){
//       return list.stream().map(function).collect(Collectors.toList());
//    }

    public List<R> map(List<T> list, Function<T, R> function){
        List<R> resultList = new ArrayList<>();
        for(T item : list){
            resultList.add(function.apply(item));
        }
        return resultList;
    }
}

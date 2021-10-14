package com.horstmann.ch3.ex7;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализуйте метод void luckySort (ArrayList<String> strings, Comparator<String> comp), вызывающий метод
 * Collections.shuffle() для списочного массива до тех пор, пока элементы этого массива располагаются в возрастающем
 * порядке, задаваемом компаратором.
 */
public class StringSequence {

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        //перегоняем в [] чтобы можно было делать sort
        String[] stringsAsArray = strings.toArray(new String[strings.size()]);
        //делаем sort, результат сохранится в ту же переменную типа String[]
        Arrays.sort(stringsAsArray, comp);
        //перегоняем отсортированный массив в List, но жить он будет в новой переменной (чтобы осталась старая версия)
        List<String> sortedArrayList = Arrays.stream(stringsAsArray).collect(Collectors.toList());
        //если то, что мы подали на входе, совпадает с отсортированной версией
        while (sortedArrayList.equals(strings)){
            //изменяем поданный на вход массив - шаффлим его
            Collections.shuffle(strings);
            //заходим заново, чтобы убедиться что теперь шафл зааффектил расположение элементов
            luckySort(strings, comp);
        }
    }
}

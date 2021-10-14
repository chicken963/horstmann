package com.horstmann.ch7.ex13;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Всякий раз, когда в отображение типа LinkedHashMap вводится новый элемент, вызывается метод removeEldestEntry().
 * Реализуйте подкласс Cache, производный от класса LinkedHashMap и ограничивающий размер отображения заданной
 * величиной, предоставляемой в конструкторе этого класса.
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> extensiableMap = new LinkedHashMap<>(2);
        Map<Integer, String> cacheMap = new Cache<>(2);
        extensiableMap.put(1, "first");
        extensiableMap.put(2, "second");
        extensiableMap.put(3, "third");

        cacheMap.put(1, "first");
        cacheMap.put(2, "second");
        cacheMap.put(3, "third");

        Map<Integer, String> cacheMapToCheckPutAll = new Cache<>(2);
        cacheMapToCheckPutAll.putAll(extensiableMap);
    }
}

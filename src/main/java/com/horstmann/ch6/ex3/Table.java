package com.horstmann.ch6.ex3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализуйте обобщенный класс Table<K,V>, управляющий списочным массивом, состоящим из элементов типа Entry<K,V>.
 * Предоставьте методы для получения значения, связанного с ключом, установки значения по заданному ключу и удаления ключа.
 */
public class Table<K, V> {
    public ArrayList<Map.Entry<K, V>> body;

    public Table() {
        this.body = new ArrayList<>();
    }

    public V get(K key){
        return this.body
                .stream()
                .filter(entry -> key.equals(entry.getKey()))
                .collect(Collectors.toList())
                .get(0).getValue();
    }

    public void set(K key, V value) {

        /*здесь я пытался предусмотреть случай когда ключа ещё нет в кейсете, но потерпел фиаско*/

//        List<K> keyset = body
//                .stream()
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//        if(!keyset.contains(key)){
//            this.body.add(body.get(0).)
//        }
        this.body.stream()
                .filter(entry -> key.equals(entry.getKey()))
                .collect(Collectors.toList())
                .get(0).setValue(value);
    }

    public void pop(K key) {
        Map.Entry<K, V> entryToRemove = this.body.stream()
                .filter(entry -> key.equals(entry.getKey()))
                .collect(Collectors.toList())
                .get(0);
        body.remove(entryToRemove);
    }

}

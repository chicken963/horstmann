package com.horstmann.ch6.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table<K, V> {
    public List<Entry> body;

    public Table() {
        this.body = new ArrayList<>();
    }

    public V get(K key) {
        return this.body
                .stream()
                .filter(entry -> key.equals(entry.getKey()))
                .collect(Collectors.toList())
                .get(0).getValue();
    }

    public void set(K key, V value) {

        List<K> keyset = body
                .stream()
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        if (!keyset.contains(key)) {
            this.body.add(new Entry(key, value));
        } else {
            this.body.stream()
                    .filter(entry -> key.equals(entry.getKey()))
                    .collect(Collectors.toList())
                    .get(0).setValue(value);
        }
    }

    public void pop(K key) {
        Entry entryToRemove = this.body.stream()
                .filter(entry -> key.equals(entry.getKey()))
                .collect(Collectors.toList())
                .get(0);
        body.remove(entryToRemove);
    }

    public class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    public void print() {
        for (Entry entry : body) {
            System.out.println(entry.key + " goes " + entry.value);
        }
    }
}

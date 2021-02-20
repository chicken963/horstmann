package com.horstmann.ch2.ex16;

import java.util.LinkedList;
import java.util.List;

/**
 * Реализуйте в классе Queue неограниченную очередь символьных строк. Предоставьте метод add() для ввода элемента в
 * хвост очереди и метод remove () для удаления элемента из головы очереди. Организуйте хранение элементов
 * в виде связного списка узлов, создав вложенный класс Node. Должен ли этот класс быть статическим?
 */
public class Queue {
    private List<Node> content = new LinkedList<>();

    public void add(String stringToAdd) {
        Node nodeToAdd = new Node(stringToAdd);
        this.content.add(nodeToAdd);
    }

    public void remove() {
        this.content.remove(0);
    }

    /**
     *  Должен ли этот класс быть статическим? - да, так как экземпляры Node не обязаны быть привязаны к конкретному
     *  экземпляру очереди
     */
    private static class Node {
        private String symbols;
        public Node(String symbols){
            this.symbols = symbols;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.remove();
        queue.remove();
    }
}

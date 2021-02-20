package com.horstmann.ch2.ex17;

/**
 * Предоставьте итератор — объект, извлекающий по порядку элементы очереди из предыдущего упражнения.
 * Сделайте класс Iterator вложенным и определите в нем методы next () и hasNext (). Определите в классе Queue метод
 * iterator (), возвращающий ссылку на объект Queue.Iterator. Должен ли внутренний класс Iterator быть статическим?
 */
public class Queue {
    private Node lastNode;
    private Node headNode;

    private Iterator iterator() {
        return new Iterator();
    }

    public void add(String stringToAdd) {
        Node nodeToAdd = new Node(stringToAdd);
        Node bufferedNode = null;
        if (this.lastNode != null) {
            bufferedNode = this.lastNode;
        } else {
            this.headNode = nodeToAdd;
        }
        this.lastNode = nodeToAdd;

        if (bufferedNode != null) {
            bufferedNode.linkToNext = nodeToAdd;
        }
    }

    public void remove() {
        this.headNode = this.headNode.linkToNext;
    }

    private static class Node {
        public String getSymbols() {
            return symbols;
        }

        private String symbols;
        Node linkToNext;

        public Node(String symbols) {
            this.symbols = symbols;
        }
    }

    /**
     * Должен ли внутренний класс Iterator быть статическим? - нет, так как экземпляр Iterator должен быть привязан к
     * экземпляру Queue
     */
    private class Iterator {
        private Node actualNode;
        private boolean isCalledForTheFirstTime = true;

        public Iterator() {
            this.actualNode = Queue.this.headNode;
        }

        public Node next() {
            if (isCalledForTheFirstTime) {
                isCalledForTheFirstTime = false;
            } else {
                actualNode = actualNode.linkToNext;
            }
            return actualNode;
        }

        public boolean hasNext() {
            return actualNode.linkToNext != null;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.add("Four");
        queue.remove();
        Iterator iterator = queue.iterator();
        do {
            System.out.println(iterator.next().getSymbols());
        } while (iterator.hasNext());
    }
}

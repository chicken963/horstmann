package com.horstmann.ch5.ex8;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Разработайте вспомогательный метод, чтобы воспользоваться классом ReentrantLock в операторе try с ресурсами.
 * Вызовите метод lоск() и возвратите объект класса, который реализует интерфейс AutoCloseable
 * и в методе которого close() вызывается метод unlock(), но не генерируется никаких исключений.
 */
public class Main {
    public static void main(String[] args) {
        newLock();
    }

    private static Closeable newLock(){
        //делаем локальный класс
        class CloseableReentrantLock extends ReentrantLock implements Closeable {
            @Override
            public void close(){
                this.unlock();
            }
        }
        //делаем оператор try с ресурсами
        try(CloseableReentrantLock lock = new CloseableReentrantLock()){
            lock.lock();
            return lock;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

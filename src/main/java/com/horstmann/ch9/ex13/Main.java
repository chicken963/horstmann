package com.horstmann.ch9.ex13;

import java.io.*;

/**
 * Реализуйте метод для получения клона любого объекта сериализируемого сначала в массив байтов
 * и затем десериализируемого оттуда.
 */
public class Main {
    public static void main(String[] args) {
        byte[] buffer = new byte[128];
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        TestSeries andrew = new TestSeries("Andrew", 1);

        //запись в массив
        ;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(bo)) {
            objectOutputStream.writeObject(andrew);
            buffer = bo.toByteArray();
            bo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //получение из массива
        InputStream bi = new ByteArrayInputStream(buffer);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(bi)) {
            TestSeries andrewTwin = (TestSeries) objectInputStream.readObject();
            System.out.println(andrew == andrewTwin);
            System.out.println(andrew.equals(andrewTwin));
            bi.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

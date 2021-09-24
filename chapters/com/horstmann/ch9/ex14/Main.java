package com.horstmann.ch9.ex14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализуйте сериализируемый класс Point с переменными экземпляра для хранения координат точки х и у.
 * Напишите одну программу для сериализации массива объектов типа Point в файл, а другую — для чтения из файла.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path fileToSerialize = Paths.get("chapters/com/horstmann/ch9/ex14/container.txt");
        List<Point> sourcePoints = Arrays.asList(
                new Point(3,4),
                new Point(-1.3,7.23),
                new Point(54,198.6)
        );

        serializeToFile(sourcePoints, fileToSerialize);
        List<Point> targetPoints = deserializeFromFile(fileToSerialize);
        for (Point point : targetPoints) {
            System.out.println(point.toString());
        }
    }

    private static void serializeToFile(List<Point> sourcePoints, Path fileToSerialize)  {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(fileToSerialize))) {
            for (Point point : sourcePoints) {
                objectOutputStream.writeObject(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Point> deserializeFromFile(Path fileToSerialize) {
        List<Point> points = new LinkedList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(fileToSerialize))) {
            while (true) {
                Point point = (Point) objectInputStream.readObject();
                points.add(point);
            }
        } catch (EOFException e) {
            return points;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return points;
    }
}

package com.horstmann.ch9.ex15;

import com.horstmann.ch9.ex14.Point;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Продолжите предыдущее упражнение, но измените представление данных типа Point таким образом, чтобы хранить координаты
 * точки в массиве. Что произойдет при попытке прочитать в новой версии файл, сформированный в предыдущей версии? И что
 * произойдет, если исправить идентификатор serialVersionUID? Что бы вы сделали, если бы ваша жизнь зависела от создания
 * новой версии, совместимой с прежней?
 */
public class WithoutBackwardCompatibility {
    /**
     * Что произойдет при попытке прочитать в новой версии файл, сформированный в предыдущей версии?
     * @param args args
     * @throws IOException e
     */
    public static void main(String[] args) throws IOException {
        Path fileToSerialize = Paths.get("chapters/com/horstmann/ch9/ex14/container.txt");
        List<Point> targetPoints = serializeFromFile(fileToSerialize);
    }

    private static List<Point> serializeFromFile(Path fileToSerialize) {
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

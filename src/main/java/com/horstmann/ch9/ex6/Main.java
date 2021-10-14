package com.horstmann.ch9.ex6;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

/**
 * Формат BMP для файлов несжатых изображений хорошо документирован и прост. Используя произвольный доступ, напишите
 * программу, отражающую положение каждого ряда пикселей, не прибегая к записи в новый файл.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("chapters/com/horstmann/ch9/ex6/swim.bmp", "rw");
        List<Byte> byteRow = new LinkedList<>();
        Byte currentByte = file.readByte();
        while (currentByte != -1) {
            currentByte = file.readByte();
            while (currentByte != 0){
                byteRow.add(file.readByte());
                currentByte = file.readByte();
            }
            Collections.reverse(byteRow);
            byte[] bytes = new byte[byteRow.size()];
            for (int i=0; i < byteRow.size(); i++) bytes[i] = byteRow.get(i);
            System.out.println("\n\n");
            file.write(bytes);
        }

    }
}

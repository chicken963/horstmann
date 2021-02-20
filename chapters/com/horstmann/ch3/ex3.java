package com.horstmann.ch3;

import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Каковы все супертипы для типа String, Scanner или ImageOutputStream?
 * Следует иметь в виду, что у каждого типа имеется свой супертип.
 * Класс или интерфейс без явно объявленного супертипа имеет супертип Object.
 */
public class ex3 {
    public ex3() throws FileNotFoundException {
    }

    CharSequence cSeq = new String("cSeq");
    Serializable serializable = new String("serializable");
    Comparable<String> comparable = new String("abc");
    Object object = new String("abc");

    InputStream inputStream = new FileInputStream("abc");
    Iterator<String> iterator = new Scanner(inputStream);
    Closeable closeable = new Scanner(inputStream);
    AutoCloseable autoCloseable = new Scanner(inputStream);
    Object objectForScanner = new Scanner(inputStream);

//    ImageInputStream imageInputStream = new ImageOutputStream();
//    DataOutput dataOutput = new ImageOutputStream();
//    DataInput dataInput = new ImageOutputStream();
//    Closeable closeable = new ImageOutputStream();
//    AutoCloseable autoCloseable = new ImageOutputStream();
//    Object objectForImage = new ImageOutputStream();
}

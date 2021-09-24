package com.horstmann.ch9.ex1;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/**
 * Напишите служебный метод для копирования всего содержимого из потока ввода InputStream в поток вывода OutputStream,
 * не пользуясь временными файлами. Предоставьте другое решение без цикла, используя методы из класса Files и временный файл.
 */
public class Main {

    private static void copy(InputStream in, OutputStream out) throws IOException {
        int BUFFER_SIZE = 8192;
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buf)) > 0) {
            out.write(buf, 0, n);
        }
    }

    private static void copyViaTempFile(InputStream in, OutputStream out) throws IOException {
        Path tempFilePath = Files.createTempFile(null, ".txt");
        Files.copy(in, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(tempFilePath, out);
    }

    @Test
    public void checkBufferCopy() throws IOException {
        //initial file creation
        List<String> content = Arrays.asList("Wake", "me", "up", "inside");
        Path sourceFilePath = Paths.get("chapters/com/horstmann/ch9/ex1/source1.txt");
        Files.deleteIfExists(sourceFilePath);
        Files.createFile(sourceFilePath);
        Files.write(sourceFilePath, content, StandardCharsets.UTF_8);

        //create input stream from the source file
        InputStream in = Files.newInputStream(sourceFilePath);

        //create new outputStream
        Path targetFilePath = Paths.get("chapters/com/horstmann/ch9/ex1/target1.txt");
        Files.deleteIfExists(targetFilePath);
        OutputStream out = Files.newOutputStream(targetFilePath);

        copy(in, out);
    }

    @Test
    public void checkTempFileCopy() throws IOException {
        //initial file creation
        List<String> content = Arrays.asList("Wake", "me", "up", "inside");
        Path sourceFilePath = Paths.get("chapters/com/horstmann/ch9/ex1/source2.txt");
        Files.deleteIfExists(sourceFilePath);
        Files.createFile(sourceFilePath);
        Files.write(sourceFilePath, content, StandardCharsets.UTF_8);

        //create input stream from the source file
        InputStream in = Files.newInputStream(sourceFilePath);

        //create new outputStream
        Path targetFilePath = Paths.get("chapters/com/horstmann/ch9/ex1/target2.txt");
        Files.deleteIfExists(targetFilePath);
        OutputStream out = Files.newOutputStream(targetFilePath);

        copyViaTempFile(in, out);
    }
}

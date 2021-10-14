package com.horstmann.ch9.ex3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Напишите программу для чтения текстового файла, содержащего слова в основном на английском языке, и определения типа
 * кодировки: ASCII, ISO 8859-1, UTF-8 или UTF-16.
 * Если это кодировка UTF-16, то программа должна определить порядок следования байтов.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Charset> charsets = Arrays.asList(StandardCharsets.US_ASCII, StandardCharsets.ISO_8859_1,
                StandardCharsets.UTF_8, StandardCharsets.UTF_16);
        List<Integer> firstBytes = new ArrayList<>();
        for (Charset charset : charsets) {
            InputStream in = new FileInputStream("chapters/com/horstmann/ch9/ex3/content.txt");
            Reader reader = new InputStreamReader(in, charset);
            firstBytes.add(reader.read());
        }
        boolean isUTF16 = firstBytes.get(3).equals(0xFEFF);
    }
}

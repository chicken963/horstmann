package com.horstmann.ch9.ex2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Напишите программу для чтения текстового файла и создания файла с таким же именем, но с расширением .toc. Этот файл
 * должен содержать список всех слов из входного файла, а также список номеров строк, в которых встречается каждое слово.
 * Имейте в виду, что содержимое входного файла представлено в кодировке UTF-8.
 */
public class Main {
    private static Map<String, Set<Integer>> wordStatistics;

    public static void main(String[] args) throws IOException {
        generateWordStatistics(Paths.get("chapters/com/horstmann/ch9/ex2/content.txt"));
    }

    private static void generateWordStatistics(Path sourcePath) throws IOException {
        wordStatistics = new HashMap<>();
        List<String> lines = Files.readAllLines(sourcePath, StandardCharsets.UTF_8);
        lines.forEach(line -> addStringContentToStatistics(line, lines.indexOf(line) + 1));
        String sourceFileName = sourcePath.getFileName().toString();
        String fileNameWithoutExtension = sourceFileName.substring(0, sourceFileName.lastIndexOf('.'));
        Path targetPath = Paths.get(sourcePath.getParent().toString(), fileNameWithoutExtension + ".toc");
        Files.deleteIfExists(targetPath);
        List<String> linesToWrite = prepareForOutput(wordStatistics);
        Files.write(targetPath, linesToWrite, StandardCharsets.UTF_8);
    }

    private static void addStringContentToStatistics(String line, int lineNumber) {
        List<String> words = Arrays.stream(line.split("[.,:;!? ]"))
                .filter(com.horstmann.ch8.ex6.Main::isAlphabetic)
                .collect(Collectors.toList());
        words.forEach(word -> addWordToStatistics(word, lineNumber));
    }

    private static void addWordToStatistics(String word, int lineNumber) {
        if (!wordStatistics.containsKey(word)) {
            wordStatistics.put(word, new HashSet<Integer>() {{
                add(lineNumber);
            }});
        } else {
            wordStatistics.get(word).add(lineNumber);
        }
    }

    private static List<String> prepareForOutput(Map<String, Set<Integer>> wordStatistics) {
        List<String> output = new ArrayList<>();
        wordStatistics.keySet().forEach(key ->
                output.add(key + ": " + wordStatistics.get(key).stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))));
        return output;
    }
}

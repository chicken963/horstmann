package com.horstmann.ch10.ex1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Используя параллельные потоки данных, найдите в каталоге все файлы, содержащие заданное слово.
 * Как найти только первый файл? Действительно ли поиск файлов осуществляется параллельно?
 */
public class Main {


    public static List<Path> findFilesContainingWord(String sourceDir, String targetWord) {
        Path pathDir = Paths.get(sourceDir);
        List<Path> allFiles = Arrays.stream(Objects.requireNonNull(pathDir.toFile().listFiles()))
                .filter(File::isFile)
                .map(File::toPath)
                .collect(Collectors.toList());
        ExecutorService executor = Executors.newFixedThreadPool(allFiles.size());
        List<Path> suitablePaths = new ArrayList<>();
        List<Callable<Path>> tasks = new ArrayList<>();
        for (Path path : allFiles) {
            tasks.add(() -> {
                long numberOfLinesWithWord = Files.lines(path)
                        .filter(line -> line.contains(targetWord)).count();
                return numberOfLinesWithWord > 0L ? path : null;
            });
        }
        ;
        List<Future<Path>> results = null;
        try {
            results = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<Path> result : results) {
            try {
                if (result.get() != null) {
                    suitablePaths.add(result.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return suitablePaths;
    }

    public static Path findAnyFileContainingWord(String sourceDir, String targetWord) {
        Path pathDir = Paths.get(sourceDir);
        List<Path> allFiles = Arrays.stream(Objects.requireNonNull(pathDir.toFile().listFiles()))
                .filter(File::isFile)
                .map(File::toPath)
                .collect(Collectors.toList());
        ExecutorService executor = Executors.newFixedThreadPool(allFiles.size());
        List<Callable<Path>> tasks = new ArrayList<>();
        for (Path path : allFiles) {
            tasks.add(() -> {
                long numberOfLinesWithWord = Files.lines(path)
                        .filter(line -> line.contains(targetWord)).count();
                return numberOfLinesWithWord > 0L ? path : null;
            });
        }

        try {
            return executor.invokeAny(tasks);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}

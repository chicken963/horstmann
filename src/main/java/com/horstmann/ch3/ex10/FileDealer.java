package com.horstmann.ch3.ex10;

import java.io.File;
import java.io.FileFilter;

/**
 * Используя методы listFiles(FileFilter)и isDirectory из класса java.io.File, напишите метод, возвращающий все
 * подкаталоги из заданного каталога. Воспользуйтесь для этой цели лямбда-выражением вместо объекта типа FileFilter.
 * Сделайте то же самое, используя ссылку на метод и анонимный внутренний класс.
 */
public class FileDealer {
    public static File[] getSubdirectories(File currentDirectory){
        return currentDirectory.listFiles(pathname -> pathname.isDirectory());
    }

    /**
     * Сделайте то же самое, используя ссылку на метод
     * @param currentDirectory current directory
     * @return list of subdirectories
     */
    public static File[] getSubdirectoriesUsingMethodLink(File currentDirectory){
        return currentDirectory.listFiles(File::isDirectory);
    }

    /**
     * Сделайте то же самое, используя анонимный внутренний класс
     * @param currentDirectory current directory
     * @return list of subdirectories
     */
    public static File[] getSubdirectoriesUsingAnonymousClass(File currentDirectory){
        return currentDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
    }
}

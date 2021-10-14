package com.horstmann.ch3.ex11;

import java.io.File;


/**
 * Используя метод list (FilenameFilter) из класса java.io.File, напишите метод, возвращающий все файлы из заданного
 * каталога с указанным расширением. Воспользуйтесь для этой цели лямбда-выражением вместо объекта типа FilenameFilter.
 * Какая переменная из объемлющей области действия захватывается лямбда-выражением?
 */
public class MyFilenameFilter {
    public MyFilenameFilter(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    /**
     * Какая переменная из объемлющей области действия захватывается лямбда-выражением?
     * я бы сказал, что захватываются обе, но по факту используется одна
     * @param currentDirectory current directory
     * @param extension file
     * @return list sorted by extension
     */
    private File currentDirectory;
    public String[] listByExtension(String extension){
        return this.currentDirectory.list((file, name)-> name.endsWith(extension));
    }
}

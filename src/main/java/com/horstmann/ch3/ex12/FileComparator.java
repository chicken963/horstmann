package com.horstmann.ch3.ex12;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Если задан массив объектов типа File, отсортируйте его таким образом, чтобы каталоги следовали перед файлами, а
 * в каждой группе отсортируйте элементы по пути к ним.
 * Воспользуйтесь лямбда-выражением, чтобы указать компаратор типа Comparator.
 */
public class FileComparator {
    /**
     * Воспользуйтесь лямбда-выражением, чтобы указать компаратор типа Comparator.
     * Я пошёл на полумеры - объявил компаратор как лямбда-выражение, но определил в нём только один параметр для
     * сравнения
     */
    public static File[] sortByTypeAndPath(File[] fileList){
        Comparator<File> byPath =
                (File f1, File f2)-> Boolean.compare(!f1.isDirectory(), !f2.isDirectory());
//        Arrays.sort(fileList,
//                Comparator.comparing(File::isDirectory).reversed()
//                        .thenComparing(File::getPath));
        Arrays.sort(fileList,
                byPath.thenComparing(File::getPath));
        return fileList;
    }
}

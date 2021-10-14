package com.horstmann.ch9.ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Используя регулярные выражения, извлеките имена каталогов (в виде массива символьных строк), имя и расширение файла
 * из абсолютного или относительного пути вроде /home/cay/myfile.txt.
 */
public class Main {
    public static void main(String[] args) {
        String path = "C:/Users/alan0419/IdeaProjects/home/com/nc/edu/test automation/myfile.txt";
        List<String> catalogues = extractCatalogues(path);
        String filename = extractFilename(path);
        String extension = extractExtension(path);
    }

    private static String extractExtension(String path) {
        Pattern extensionPattern = Pattern.compile("(\\w+)$");
        Matcher matcher = extensionPattern.matcher(path);
        if(matcher.find()){
            return matcher.group();
        }
        return null;
    }

    private static String extractFilename(String path) {
        Pattern extensionPattern = Pattern.compile("(\\w+).(\\w+)$");
        Matcher matcher = extensionPattern.matcher(path);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    private static List<String> extractCatalogues(String path) {
        List<String> catalogues = new ArrayList<>();
        Pattern extensionPattern = Pattern.compile("([!@#$%^&()\\-=+,.~`\\w ]+)/");
        Matcher matcher = extensionPattern.matcher(path);
        while(matcher.find()){
            catalogues.add(matcher.group(1));
        }
        return catalogues;
    }
}

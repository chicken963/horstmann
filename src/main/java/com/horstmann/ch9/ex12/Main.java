package com.horstmann.ch9.ex12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Придумайте реальный пример применения ссылок на группы в методе Matcher.replaceAll() и реализуйте его на практике
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String sourceString = Files.readAllLines(Paths.get("chapters/com/horstmann/ch9/ex12/content.txt"))
                .stream()
                .collect(Collectors.joining("\n"));
        Pattern kazakhNamePattern = Pattern.compile("((Ай)|(Али)|(Нур))+(\\p{IsCyrillic})*((хан)|(жан)|(бек))+");
        Matcher matcher = kazakhNamePattern.matcher(sourceString);
        String output = matcher.replaceAll("казах");
        System.out.println(output);

    }
}

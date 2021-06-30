package com.horstmann.ch8.ex8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.horstmann.ch8.ex7.Main.scanFile;

/**
 * Прочитайте слова из файла /usr/share/dict/words (или аналогичного списка слов) в поток данных и получите массив всех
 * слов, содержащих пять отдельных гласных.
 */
public class Main {
    private static final int aLetterCode = 1072;
    private static final int eLetterCode = 1077;
    private static final int eeLetterCode = 1105;
    private static final int iLetterCode = 1080;
    private static final int oLetterCode = 1086;
    private static final int uLetterCode = 1091;
    private static final int yLetterCode = 1099;
    private static final int aeLetterCode = 1101;
    private static final int ueLetterCode = 1102;
    private static final int yaLetterCode = 1103;
    private static final List<Integer> consonantCodePoints = Arrays.asList(
            aLetterCode,
            eLetterCode,
            eeLetterCode,
            iLetterCode,
            oLetterCode,
            uLetterCode,
            yLetterCode,
            aeLetterCode,
            ueLetterCode,
            yaLetterCode);

    public static void main(String[] args) {
        List<String> words = scanFile("chapters/com/horstmann/ch8/ex8/content.txt");
        List<String> fiveSeparateConsonantsWords = words.stream()
                .filter(Main::hasFiveConsonants)
                .collect(Collectors.toList());
        for (String word : fiveSeparateConsonantsWords) {
            System.out.println(word);
        }
    }

    private static boolean hasFiveConsonants(String word) {
        List<Integer> consonantPositions = new ArrayList<>();
        OptionalInt firstConsonantIndex;
        do {
            firstConsonantIndex = word.codePoints().filter(consonantCodePoints::contains).findFirst();
            if (firstConsonantIndex.isPresent()) {
                int index = word.indexOf(firstConsonantIndex.getAsInt());
                consonantPositions.add(index);
                word = composeString(word.split(word.substring(index, index + 1)));
            }

        } while (firstConsonantIndex.isPresent());
        return consonantPositions.size() >= 5
                && consonantPositions.stream().distinct().count() == consonantPositions.size();
    }

    private static String composeString(String[] snippets) {
        StringBuilder builder = new StringBuilder();
        for (String snippet : snippets) {
            builder.append(snippet);
        }
        return builder.toString();
    }
}

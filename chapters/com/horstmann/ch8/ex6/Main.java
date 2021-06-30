package com.horstmann.ch8.ex6;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * пользуйтесь методом String.codePoints() для реализации метода, проверяющего, является ли символьная строка словом,
 * состоящим только из букв. (Подсказка: воспользуйтесь методом Character.isAlphabetic().) Реализуйте тем же самым
 * способом метод, проверяющий, является ли символьная строка достоверным в Java идентификатором.
 */
public class Main {

    private static final int SPACE_ASCII_CODE = 95;
    private static final int DOLLAR_ASCII_CODE = 36;

    public static boolean isAlphabetic(String word) {
        while (word.matches("^[.,\\-?!«\"]+[\\w\\p{IsCyrillic}]+[.,\\-?!»\"]*$")) {
            word = word.substring(1);
        }
        while (word.matches("[\\w\\p{IsCyrillic}]+[.,\\-?!»\",\\.]+$")) {
            word = word.substring(0, word.length() - 1);
        }
        return word.codePoints().allMatch(Character::isAlphabetic);
    }

    public static String alphabetize(String word) {
        while (word.matches("^[.,\\-?!«\"]+[\\w\\p{IsCyrillic}]+[.,\\-?!»\"]*$")) {
            word = word.substring(1);
        }
        while (word.matches("[\\w\\p{IsCyrillic}]+[.,\\-?!»\",\\.]+$")) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }

    private static boolean isJavaIdentificator(String word) {
        return isWholeContentValid(word) && isFirstLetterValid(word);
    }

    private static boolean isWholeContentValid(String word) {
        return word.codePoints().allMatch(c -> Character.isAlphabetic(c)
                || Character.isDigit(c)
                || c == SPACE_ASCII_CODE
                || c == DOLLAR_ASCII_CODE);
    }

    private static boolean isFirstLetterValid(String word) {
        return Character.isAlphabetic(word.codePoints().findFirst().getAsInt())
                || word.codePoints().findFirst().getAsInt() == SPACE_ASCII_CODE
                || word.codePoints().findFirst().getAsInt() == DOLLAR_ASCII_CODE;
    }

    @Test
    public void javaIdentificatorsTest() {
        assertFalse(isJavaIdentificator("Billie Jean"));
        assertTrue(isJavaIdentificator("var"));
        assertTrue(isJavaIdentificator("var1"));
        assertFalse(isJavaIdentificator("1var"));
        assertTrue(isJavaIdentificator("_1var"));
        assertTrue(isJavaIdentificator("$1var"));
        assertTrue(isJavaIdentificator("va$r"));
    }

    @Test
    public void alphabeticTest() {
        assertFalse(isAlphabetic("R2D2"));
        assertTrue(isAlphabetic("Billie"));
        assertTrue(isAlphabetic("\"Billie"));
        assertTrue(isAlphabetic("\"Billie?!"));
        assertTrue(isAlphabetic("\"-Billie,"));
        assertFalse(isAlphabetic("Billie Jean"));
        assertFalse(isAlphabetic("\"Billie Jean"));
        assertFalse(isAlphabetic("\"Billie\"Jean"));
    }
}

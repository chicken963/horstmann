package com.horstmann.ch10.ex1;

import java.nio.file.Path;
import java.util.List;

import static com.horstmann.ch10.ex1.Main.findAnyFileContainingWord;
import static com.horstmann.ch10.ex1.Main.findFilesContainingWord;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test {

    private static final String SOURCE_DIRECTORY = "src\\test\\resources\\dir";
    private static final String KEYWORD = "keyword is here";

    @org.junit.Test
    public void invokeAllTest() {
        List<Path> pathsContainingKeyword = findFilesContainingWord(SOURCE_DIRECTORY, KEYWORD);
        assertEquals(2, pathsContainingKeyword.size());
        assertEquals("src\\test\\resources\\dir\\file3.txt", pathsContainingKeyword.get(0).toString());
        assertEquals("src\\test\\resources\\dir\\file5.txt", pathsContainingKeyword.get(1).toString());

    }

    @org.junit.Test
    public void invokeAnyTest() {
        int numberOfFile3 = 0;
        int numberOfFile5 = 0;
        for (int i=0; i < 1000; i++) {
            Path anyPathContainingKeyword = findAnyFileContainingWord(SOURCE_DIRECTORY, KEYWORD);
            if (anyPathContainingKeyword != null &&
                    "src\\test\\resources\\dir\\file3.txt".equals(anyPathContainingKeyword.toString())) {
                numberOfFile3++;
            } else if (anyPathContainingKeyword != null &&
                    "src\\test\\resources\\dir\\file5.txt".equals(anyPathContainingKeyword.toString())) {
                numberOfFile5++;
            }
        }
        assertTrue(numberOfFile3 > 0 && numberOfFile5 > 0);
    }
}

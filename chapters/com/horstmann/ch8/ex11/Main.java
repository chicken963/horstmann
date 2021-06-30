package com.horstmann.ch8.ex11;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.horstmann.ch8.ex7.Main.scanFile;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Допустим, что ваш непосредственный начальник дал вам задание написать метод public static <Т> boolean isFinite(Stream<T> stream).
 * Почему это не самая удачная мысль? Все равно напишите этот метод.
 */
public class Main {
    /**
     * Почему это не самая удачная мысль? потому что нет надежного способа это проверить + вычислительно затратно
     */
    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.spliterator().getExactSizeIfKnown() >= 0;
    }

    @Test
    public void testStreamFinite() {
        List<String> words = scanFile("chapters/com/horstmann/ch8/ex9/content.txt");
        Stream<String> wordsStream = words.stream();
        assertFalse(isFinite(Stream.iterate(0, i -> i + 2)));
        assertTrue(isFinite(Stream.iterate(0, i -> i + 2).limit(100)));
        assertTrue(isFinite(wordsStream));
    }
}

package com.horstmann.ch1;

/**
 * В разделе 1.5.3 был приведен пример сравнения двух символьных строк s и t при вызове метода s. equals (t), но не с
 * помощью операции s != t. Придумайте другой пример, в котором не применяется метод substring ().
 */
public class ex9 {

    public static void main(String[] args) {
        String part1 = "Wo";
        String part2 = "rld";
        System.out.println(part1 + part2 == "World");
        System.out.println((part1 + part2).equals("World"));
    }
}

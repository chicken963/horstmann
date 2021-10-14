package com.horstmann.ch1;

/**
 * Усовершенствуйте упоминавшийся ранее метод average () таким образом, чтобы он вызывался хотя бы с одним параметром.
 */

public class ex16 {
    public static void main(String[] args) {
        System.out.println(average(3, 5, 5, 3, 8));
    }

    public static double average(double first, double... values) {
        double sum = 0;
        double average = first;
        if (values.length > 0) {
            for (double v : values) {
                sum += v;
            }
            average = (first + sum) / (values.length + 1);
        }
        return average;
    }
}

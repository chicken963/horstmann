package com.horstmann.ch4.ex1;

/**
 * Определите класс Point с конструктором Point (double х, double у) и методами доступа getX(), getY(). Определите
 * также подкласс LabeledPoint с конструктором LabeledPoint(String label, double x, double y) pi методом
 * доступа getLabel().
 */
public class Main {


    public static void main(String[] args) {
        LabeledPoint p = new LabeledPoint(3, 5, "new Point");
        System.out.println(p.getLabel());
    }
}

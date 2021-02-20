package com.horstmann.ch4.ex5;

import com.horstmann.ch4.ex2.Point;

public class Circle extends Shape {
    private double radius;
    private Point cetner;

    public Circle(Point center, double radius) {
        this.cetner = center;
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return this.cetner;
    }

    @Override
    public Shape clone() {
        return new Circle(new Point(cetner.getX(), cetner.getY()), radius);
    }
}

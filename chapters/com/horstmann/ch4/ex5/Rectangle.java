package com.horstmann.ch4.ex5;

import com.horstmann.ch4.ex2.Point;

public class Rectangle extends Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
       this.point = new Point(topLeft.getX(), topLeft.getY());
       this.moveBy(width / 2, - height / 2);
       return this.point;
    }

    @Override
    public Shape clone() {
        return new Rectangle(new Point(topLeft.getX(), topLeft.getY()), width, height);
    }
}

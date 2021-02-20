package com.horstmann.ch4.ex5;

import com.horstmann.ch4.ex2.Point;

public class Line extends Shape {
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Point getCenter() {
        this.point = new Point(from.getX(), from.getY());
        moveBy((to.getX() - from.getX()) / 2, (to.getY() - from.getY()) / 2);
        return  this.point;
    }

    @Override
    public Shape clone() {
        return new Line(new Point(from.getX(), from.getY()), new Point(to.getX(), to.getY()));
    }
}

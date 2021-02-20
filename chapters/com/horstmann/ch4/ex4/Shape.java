package com.horstmann.ch4.ex4;

import com.horstmann.ch4.ex2.Point;

public abstract class Shape {
    public Point point;
    public void moveBy(double dx, double dy){
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }
    public abstract Point getCenter();
}

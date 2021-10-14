package com.horstmann.ch9.ex14;

import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = 1L;
    private double x;
    private double y;

//    public Point(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public double getX() {
//        return x;
//    }
//
//    public void setX(double x) {
//        this.x = x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    public void setY(double y) {
//        this.y = y;
//    }
//
//    @Override
//    public String toString() {
//        return "Point with x=" + this.x + ", y=" + this.y;
//    }

    private double[] coordinates;

    public Point(double x, double y) {
        this.coordinates = new double[2];
        coordinates[0] = x;
        coordinates[1] = y;
    }

    public double getX() {
        return coordinates[0];
    }

    public void setX(double x) {
        this.coordinates[0] = x;
    }

    public double getY() {
        return coordinates[1];
    }

    public void setY(double y) {
        this.coordinates[1] = y;
    }
}

package com.horstmann.ch4.ex2;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "x=" + this.x + ", y=" + this.y;
    }

    @Override
    public boolean equals(Object another){
        if (this == another) return true;
        if(!(another instanceof Point)) return false;
        Point anotherPoint = (Point) another;
        return anotherPoint.getX() == this.getX() && anotherPoint.getY() == this.getY();
    }

    @Override
    public int hashCode(){
        return (int) (29 * (31 * this.getX() + this.getY()));
    }
}
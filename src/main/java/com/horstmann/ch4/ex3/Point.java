package com.horstmann.ch4.ex3;

public class Point {
    protected double x;
    protected double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "x=" + this.getX() + ", y=" + this.getY();
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

package com.horstmann.ch7.ex10;

public class Neighbor implements Comparable<Neighbor>{
    private String name;
    private int distance;

    public Neighbor(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Neighbor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Neighbor o) {
        return this.distance - o.distance;
    }
}

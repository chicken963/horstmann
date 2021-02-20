package com.horstmann.ch4.ex1;

public class LabeledPoint extends Point {
    private String label;
    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

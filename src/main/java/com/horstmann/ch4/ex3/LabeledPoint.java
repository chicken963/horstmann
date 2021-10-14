package com.horstmann.ch4.ex3;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "x=" + this.x + ", y=" + this.y + ", label = '" + this.getLabel() + "'";
    }

    @Override
    public boolean equals(Object another) {
        if (!super.equals(another)) return false;
        LabeledPoint anotherPoint = (LabeledPoint) another;
        return anotherPoint.getLabel().equals(this.getLabel());
    }

    @Override
    public int hashCode() {
        return (int) (29 * (31 * this.x + this.y)) + this.label.hashCode();
    }
}

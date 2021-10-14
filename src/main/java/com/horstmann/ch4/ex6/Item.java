package com.horstmann.ch4.ex6;

import java.util.Objects;

public class Item {
    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    private String description;
    private double price;

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Item)) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && price == other.price;
    }

    public int hashCode() {
        return Objects.hash(description, price);
    }
}

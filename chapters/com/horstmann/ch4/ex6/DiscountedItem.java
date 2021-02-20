package com.horstmann.ch4.ex6;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(double discount, String description, double price) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        if(otherObject instanceof Item
                && !(otherObject instanceof DiscountedItem)
                && super.equals(otherObject)) return true;
        DiscountedItem other = (DiscountedItem) otherObject;
        return discount == other.discount;
    }

    public int hashCode(){
        return Objects.hash(discount, super.getDescription(), super.getPrice());
    }
}

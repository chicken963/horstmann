package com.horstmann.ch4.ex9;

public class Bicycle {
    private int price;
    private String manufacturer;
    private SteeringWheel steeringWheel;

    public Bicycle(int price, String manufacturer, SteeringWheel steeringWheel) {
        this.price = price;
        this.manufacturer = manufacturer;
        this.steeringWheel = steeringWheel;
    }

    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }
}

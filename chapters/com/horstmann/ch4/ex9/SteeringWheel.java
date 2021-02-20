package com.horstmann.ch4.ex9;

public class SteeringWheel {
    private String manufacturer;

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    private Grips grips;
    private Bicycle bicycle;

    public String getManufacturer() {
        return manufacturer;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public SteeringWheel(String manufacturer, String gripsColor) {
        this.manufacturer = manufacturer;
        this.grips = new Grips(gripsColor);
    }
}

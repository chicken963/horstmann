package com.horstmann.ch2;

/**
 * Реализуйте класс Саг, моделирующий передвижение автомобиля на бензиновом топливе по оси х. Предоставьте методы для
 * передвижения автомобиля на заданное количество километров, заполнения топливного бака заданным количеством литров
 * бензина, вычисления расстояния, пройденного от начала координат, а также уровня топлива в баке. Укажите расход
 * топлива (в км/л) в качестве параметра конструктора данного класса. Должен ли этот класс быть неизменяемым и почему?
 *
 * Неизменяемым быть не должен, так как при каждом перемещении придётся создавать новую машину
 */
public class ex9 {
    public static class Car {
        private double fuelConsumption;
        private double coordinate;
        private double fuel;

        public static final double COORDINATES_BEGINNING = 0;

        public double getCoordinate() {
            return coordinate;
        }

        public double getFuel() {
            return fuel;
        }

        public Car(double fuelConsumption) {
            this.coordinate = COORDINATES_BEGINNING;
            this.fuelConsumption = fuelConsumption;
            this.fuel = 100;
        }

        public void move(double kilometers) {
            if (this.fuel >= Math.abs(kilometers) * fuelConsumption) {
                this.coordinate += kilometers;
                this.fuel -= Math.abs(kilometers) * fuelConsumption;
                System.out.printf("Now the car is at %.1f coordinate, it has %.1f liters of fuel left",
                        this.coordinate, this.fuel);
            } else {
                this.coordinate += this.fuel / this.fuelConsumption * Math.signum(kilometers);
                this.fuel = 0;
                System.out.printf("The car is out of fuel. It has stopped at %.1f coordinate",
                        this.coordinate);
            }
        }

        public void fill(double liters) {
            this.fuel += liters;
        }
    }

    public static void main(String[] args) {
        Car car = new Car(10);
        car.move(-9);
    }
}

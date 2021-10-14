package com.horstmann.ch3.ex1;

public class Employee implements Measurable {
    private double measure;

    public Employee(double measure) {
        this.measure = measure;
    }

    @Override
    public double getMeasure() {
        return this.measure;
    }

    private static double average(Employee[] objects) {
        double sum = 0;
        for (Employee employee : objects) {
            sum += employee.getMeasure();
        }
        return sum == 0 ? 0 : sum / objects.length;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(100);
        Employee e2 = new Employee(200);
        Employee e3 = new Employee(34500);
        Employee[] eArray = new Employee[3];
        eArray[0] = e1;
        eArray[1] = e2;
        eArray[2] = e3;
        System.out.println(average(eArray));

    }

}

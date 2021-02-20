package com.horstmann.ch3.ex2;

public class Employee implements Measurable {
    public Employee(double measure) {
        this.measure = measure;
    }

    private double measure;

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

    /**
     * Зачем требуется приведение типов? - Мне не потребовалось
     * @param objects - array of objects
     * @return object with maximum measure
     */
    static Measurable largest(Measurable[] objects) {
        Measurable maxObject = null;
        double max = 0;
        for (Measurable employee : objects) {
            if (employee.getMeasure() > max) {
                max = employee.getMeasure();
                maxObject = employee;
            }
        }
        return maxObject;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee(345);
        employees[1] = new Employee(61);
        employees[2] = new Employee(34.4);
        System.out.println(average(employees));
        System.out.println(largest(employees));
    }

}

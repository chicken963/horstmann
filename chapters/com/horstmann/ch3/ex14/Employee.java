package com.horstmann.ch3.ex14;

/**
 * Организуйте вызов метода Arrays.sort(), сортирующего работников сначала по зарплате, а затем по имени.
 * Воспользуйтесь для этой цели методом Comparator.thenComparing(). Затем организуйте сортировку в обратном порядке.
 */
public class Employee {
    private int salary;
    private String name;

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return "Name: " + this.name + ", salary: " + this.salary;
    }
}

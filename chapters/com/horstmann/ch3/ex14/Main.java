package com.horstmann.ch3.ex14;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(4000, "Erjan"),
                new Employee(40000, "Elon"),
                new Employee(21300, "Ivan"),
                new Employee(21301, "Ivan"),
                new Employee(21300, "Matthew"),
        };

        System.out.println("Сначала по зп, потом по имени (по возрастанию):");
        EmployeeComparator.sortBySalaryAndNameAscending(employees);
        for (Employee e: employees){
            System.out.println(e.toString());
        }

        System.out.println("\n");
        System.out.println("Сначала по зп, потом по имени (по убыванию):");
        EmployeeComparator.sortBySalaryAndNameDescending(employees);
        for (Employee e: employees){
            System.out.println(e.toString());
        }

        System.out.println("\n");
        System.out.println("Сначала по имени, потом по зп (по убыванию):");
        EmployeeComparator.sortByNameAndSalaryAscending(employees);
        for (Employee e: employees){
            System.out.println(e.toString());
        }
    }
}

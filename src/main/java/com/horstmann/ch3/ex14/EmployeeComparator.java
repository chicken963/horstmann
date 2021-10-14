package com.horstmann.ch3.ex14;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeComparator {
    public static void sortBySalaryAndNameAscending(Employee[] employees) {
        Arrays.sort(employees,
                Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName));
    }

    public static void sortByNameAndSalaryAscending(Employee[] employees) {
        Arrays.sort(employees,
                Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary));
    }

    public static void sortBySalaryAndNameDescending(Employee[] employees) {
        Arrays.sort(employees,
                Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName).reversed());
    }
}

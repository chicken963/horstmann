package com.horstmann.ch2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;
/**
* Измените представленную в этой главе программу вывода календаря таким образом, чтобы неделя начиналась с воскресенья.
* Кроме того, организуйте перевод на новую строку в конце предыдущей, но только один раз.
* */
public class ex1 {
    private static final DayOfWeek startOfWeek = DayOfWeek.SUNDAY;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the month and year separated with space: ");
        int month = in.nextInt();
        int year = in.nextInt();
        printMonth(month, year);
    }

    private static void indent(DayOfWeek weekday) {
        int firstDayOfMonthWeekday = weekday.getValue();
        int firstWeekdayValue = startOfWeek.getValue();
        if (firstDayOfMonthWeekday > firstWeekdayValue) {
            for (int i = firstWeekdayValue; i < firstDayOfMonthWeekday; i++)
                System.out.print("    ");
        } else if (firstDayOfMonthWeekday < firstWeekdayValue) {
            for (int i = 0; i < 7 + firstDayOfMonthWeekday - firstWeekdayValue; i++)
                System.out.print("    ");
        }
    }

    private static boolean isTheEndOfWeek(DayOfWeek weekday) {
        return startOfWeek.getValue() - weekday.getValue() == 1
                || startOfWeek.getValue() - weekday.getValue() == -6;
    }

    private static void printMonth(int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek weekday = date.getDayOfWeek();
        indent(weekday);
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            if (isTheEndOfWeek(date.getDayOfWeek())) {
                System.out.println("\n");
            }
            date = date.plusDays(1);
        }
        System.out.println("\n");
    }
}
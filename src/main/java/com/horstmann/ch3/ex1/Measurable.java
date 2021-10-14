package com.horstmann.ch3.ex1;

/**
 * Предоставьте интерфейс Measurable с методом double getMeasure (), измеряющим объект определенным образом.
 * Создайте класс Employee, реализующий интерфейс Measurable.
 * Предоставьте метод double average (Measurable [ ] objects), вычисляющий среднюю меру.
 * Воспользуйтесь им для расчета средней зарплаты в массиве работников.
 */
public interface Measurable {
   double getMeasure();
}

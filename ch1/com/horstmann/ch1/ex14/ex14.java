package com.horstmann.ch1.ex14;

/**
 * Напишите программу, вводящую двумерный массив целочисленных значений и определяющую, содержится ли в нем магический
 * квадрат (т.е. одинаковая сумма значений во всех строках, столбцах и диагоналях). Принимая строки вводимых данных,
 * разбивайте их на отдельные целочисленные значения, прекратив этот процесс, когда пользователь введет пустую строку.
 */

public class ex14 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.read();
        System.out.println(matrix.containsMagicSquare());
    }




}
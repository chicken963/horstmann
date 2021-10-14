package com.horstmann.ch1.ex15;

import java.util.Scanner;

/**
 *Напишите программу, сохраняющую треугольник Паскаля вплоть до заданной величины п в переменной
 * типа ArrayList<ArrayList<Integer».
 */

public class ex15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the Pascal triangle height: ");
        int height = in.nextInt();
        PascalTriangle triangle = new PascalTriangle(height);
        triangle.draw();
    }


}

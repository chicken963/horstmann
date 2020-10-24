package com.horstmann.ch1;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        System.out.print("Please enter your angle: ");
        Scanner in = new Scanner(System.in);
        int angle = in.nextInt();
        int normalizedAngle = (angle % 360 + 360) % 360;
        int normalizedAngle2 = Math.floorMod(angle, 360);
        System.out.printf("Normalized angle is %d (alternative is %d)\n", normalizedAngle, normalizedAngle2);
    }
}

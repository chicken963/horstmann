package com.horstmann.ch3.ex10;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("As lambda expression:");
        System.out.println(Arrays.toString(FileDealer
                .getSubdirectories(new File("E:\\Users\\alan0419\\Documents"))));
        System.out.println("\nAs method link:");
        System.out.println(Arrays.toString(FileDealer
                .getSubdirectoriesUsingMethodLink(new File("E:\\Users\\alan0419\\Documents"))));
        System.out.println("\nAs anonymous class:");
        System.out.println(Arrays.toString(FileDealer
                .getSubdirectoriesUsingAnonymousClass(new File("E:\\Users\\alan0419\\Documents"))));
    }
}

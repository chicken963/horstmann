package com.horstmann.ch3.ex11;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyFilenameFilter filter = new MyFilenameFilter(new File("E:\\Users\\alan0419\\Documents"));
        System.out.println(Arrays.toString(filter.listByExtension(".xlsx")));
    }
}

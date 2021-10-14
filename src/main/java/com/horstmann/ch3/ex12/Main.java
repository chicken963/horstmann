package com.horstmann.ch3.ex12;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File[] files =
                {new File("C:\\Users\\alan0419\\IdeaProjects\\lc-master\\logcollector-backend\\target"),
                        new File("C:\\Users\\alan0419\\IdeaProjects\\lc-master\\logcollector-backend\\web"),
                        new File("C:\\Users\\alan0419\\IdeaProjects\\lc-master\\logcollector-backend\\src"),
                        new File("C:\\Users\\alan0419\\NTUSER.DAT"),
                        new File("C:\\Users\\alan0419\\Production_LC_2020_11_25_10_17_10_dump_2020_12_18_17_20_59.txt"),
                        new File("C:\\Users\\alan0419\\Executor")};
        String[] fileNames = Arrays.toString(FileComparator.sortByTypeAndPath(files)).split(", ");
        for(String fileName: fileNames){
            System.out.println(fileName);
        }
    }
}

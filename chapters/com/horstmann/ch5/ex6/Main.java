package com.horstmann.ch5.ex6;

import com.horstmann.ch5.ex5.FolderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * В разделе 5.1.6 приведен пример ошибочного внедрения блока операторов catch и finally в блок кода оператора try.
 * Исправьте этот код, во-первых, перехватив исключение в операторе finally,
 *                     во-вторых, внедрив блок операторов try/finally в блок операторов try/catch,
 *                     и в-третьих, применив оператор try с ресурсами вместе с оператором catch.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("try/catch inside finally:\n");
        firstVariant();
        System.out.println("try/catch/finally inside try/catch:\n");
        secondVariant();
        System.out.println("try with resources:\n");
        thirdVariant();
    }

//    private static void asIs(){
//        BufferedReader in = null;
//        FolderService folderService = new FolderService();
//        String filename = folderService.getCurrentClassDirectory() + "numbers.txt";
//        try {
//            in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
//            System.out.println(in.lines());
//        } catch (IOException ex) {
//            System.err.println("Caught IOException: " + ex.getMessage());
//        } finally {
//            if (in != null) {
//                in.close(); // ВНИМАНИЕ: может быть сгенерировано исключение!
//            }
//        }
//    }

    //перехватив исключение в операторе finally
    public static void firstVariant() {
        BufferedReader in = null;
        FolderService folderService = new FolderService();
        String filename = folderService.getCurrentClassDirectory() + "numbe1rs.txt";
        try {
            in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            Iterator<String> it = in.lines().iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close(); // ВНИМАНИЕ: может быть сгенерировано исключение!
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //внедрив блок операторов try/finally в блок операторов try/catch
    public static void secondVariant() {
        BufferedReader in = null;
        FolderService folderService = new FolderService();
        String filename = folderService.getCurrentClassDirectory() + "number1s.txt";
        try{
        try {
            in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            Iterator<String> it = in.lines().iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                in.close(); // ВНИМАНИЕ: может быть сгенерировано исключение!
            }
        }} catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //применив оператор try с ресурсами вместе с оператором catch
    public static void thirdVariant() {
        FolderService folderService = new FolderService();
        String filename = folderService.getCurrentClassDirectory() + "numbe1rs.txt";
        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            Iterator<String> it = in.lines().iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        } catch (Exception ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}

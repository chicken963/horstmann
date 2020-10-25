package com.horstmann.ch1.ex14;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    public ArrayList<String> bodyAfterReading;
    public ArrayList<ArrayList<Integer>> body;
    private int[][] slicedBody;
    private int minDimension;
    public boolean containsMagicSquare = true;
    private int ethalon;
    private int startStringIndex;
    private int startColumnIndex;
    private int scale;

    public void read(){
        ArrayList<String> matrix = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the matrix strings (to end up please enter an empty string): ");
        while (true) {
            String s = in.nextLine();
            if (s.isEmpty()) break;
            matrix.add(s);
        }
        this.bodyAfterReading = matrix;
        this.convertToInt();
    }

    public void convertToInt(){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for(String string: this.bodyAfterReading){
            ArrayList<Integer> convertedString = convertStringToListOfInt(string);
            matrix.add(convertedString);
        }
        this.body = matrix;
    }

    private static ArrayList<Integer> convertStringToListOfInt(String string){
        String[] stringAsArrayOfStrings = string.split("\\s+");
        ArrayList<Integer> stringAsArrayOfNumbers = new ArrayList<>();
        for(String numberAsString: stringAsArrayOfStrings){
            stringAsArrayOfNumbers.add(Integer.parseInt(numberAsString));
        }
        return stringAsArrayOfNumbers;
    }

    public void slice(){
        this.minDimension();
        int[][] slicedBody = new int[minDimension][minDimension];
        for(int i = 0; i < minDimension; i++){
            for(int j = 0; j < minDimension; j++){
                slicedBody[i][j] = this.body.get(i).get(j);
            }
        }
        this.slicedBody = slicedBody;
    }

    private int minimumNumberOfColumns(){
        int numberOfColumns = this.body.get(0).size();
        for(ArrayList<Integer> string: this.body){
            if(string.size() < numberOfColumns){
                numberOfColumns = string.size();
            }
        }
        return numberOfColumns;
    }

    private void minDimension(){
        int numberOfStrings = this.body.size();
        int numberOfColumns = this.minimumNumberOfColumns();
        this.minDimension = Math.min(numberOfStrings, numberOfColumns);
    }

    public boolean containsMagicSquare(){
        this.slice();
        outer:{
            for(int i = 0; i < this.minDimension; i++){
                for(int j = 0; j < this.minDimension; j++){
                    int maxSizeToObserve = this.minDimension - Math.max(i, j);
                    if(maxSizeToObserve > 2){
                        for(int k = 2; k < maxSizeToObserve; k++){
                            searchForMagicSquare(i, j, k);
                            if(this.containsMagicSquare){
                                break outer;
                            }
                        }
                    }
                }
            }
        }

        return this.containsMagicSquare;
    }

    private void searchForMagicSquare(int startStringIndex, int startColumnIndex, int scale) {
        this.ethalon = this.calculateColumnSum(startStringIndex, startColumnIndex, scale);
        this.startColumnIndex = startColumnIndex;
        this.startStringIndex = startStringIndex;
        this.scale = scale;
        this.checkColumns();
        this.checkStrings();
        this.checkDiagonals();

    }

    private int calculateColumnSum(int startStringIndex, int startColumnIndex, int scale){
        int columnSum = 0;
        for(int i = startStringIndex; i < startStringIndex + scale; i++){
            columnSum += this.slicedBody[i][startColumnIndex];
        }
        return columnSum;
    }

    private int calculateStringSum(int startStringIndex, int startColumnIndex, int scale){
        int stringSum = 0;
        for(int j = startColumnIndex; j < startColumnIndex + scale; j++){
            stringSum += this.slicedBody[startStringIndex][j];
        }
        return stringSum;
    }

    private void checkColumns(){
        for (int j = startColumnIndex; j < startColumnIndex + scale; j++){
            int columnSum = this.calculateColumnSum(startStringIndex, j, scale);
            if(columnSum != ethalon){
                containsMagicSquare = false;
                return;
            }
        }
    }

    private void checkStrings(){
        for (int i = startStringIndex; i < startStringIndex + scale; i++){
            int stringSum = this.calculateStringSum(i, startColumnIndex, scale);
            if(stringSum != ethalon){
                containsMagicSquare = false;
                return;
            }
        }
    }

    private void checkDiagonals(){
        int diagonalSum = 0;
        for(int j = 0; j < scale; j++){
            diagonalSum += this.slicedBody[startStringIndex + j][startColumnIndex + j];
        }
        if(diagonalSum != ethalon){
            containsMagicSquare = false;
        } else {
            diagonalSum = 0;
            for(int j = 0; j < scale; j++){
                diagonalSum += this.slicedBody[startStringIndex + scale - j][startColumnIndex + j];
            }
            if(diagonalSum != ethalon){
                containsMagicSquare = false;
            }
        }
    }
}

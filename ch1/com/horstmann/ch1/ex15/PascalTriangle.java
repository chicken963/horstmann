package com.horstmann.ch1.ex15;

import java.math.BigInteger;
import java.util.ArrayList;
import static com.horstmann.ch1.ex6.factorial;

public class PascalTriangle {
    private ArrayList<ArrayList<Integer>> body = new ArrayList<>();


    public PascalTriangle(int n) {
        this.createPascalTriangle(n);
    }

    private void createPascalTriangle(int n){

        int degree = 1;
        while (degree <= n){
            this.add(degree);
            degree++;
        }
    }

    private void add (int n){
        ArrayList<Integer> pascalString = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            BigInteger coef = factorial(n).divide(factorial(n - i).multiply(factorial(i)));
            Integer intCoef = coef.intValue();
            pascalString.add(intCoef);
        }
        this.body.add(pascalString);
    }

    public void draw(){
//        for(ArrayList<Integer> pascalString: this.body){
//            System.out.println(pascalString);
//        }
        System.out.println(this.body);
    }

}

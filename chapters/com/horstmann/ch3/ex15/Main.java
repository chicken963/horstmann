package com.horstmann.ch3.ex15;

import com.horstmann.ch3.ex4.IntSequence;

import java.util.Random;

/**
 * Реализуйте локальный класс RandomSequence , упоминавшийся в разделе 3.9.1,
 * как вложенный класс за пределами метода randomInts().
 */
public class Main {
    private static Random generator = new Random();

    private static class RandomSequence implements IntSequence {
        private Random generator;
        private int low;
        private int high;

        public RandomSequence(Random generator, int low, int high) {
            this.generator = generator;
            this.low = low;
            this.high = high;
        }

        public int next(){
            return low + generator.nextInt(high - low + 1);
        }

        public boolean hasNext(){return true;}
    }

    public static IntSequence randomInts(int low, int high){
        return new RandomSequence(generator, low, high);
    }

    public static void main(String[] args) {
        IntSequence seq = randomInts(4, 9);
        for (int i = 0; i < 20; i++){
            System.out.println(seq.next());
        }
    }
}

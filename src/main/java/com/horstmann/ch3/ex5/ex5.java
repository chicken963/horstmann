package com.horstmann.ch3.ex5;

public class ex5 implements IntSequence {
    private int value;

    public ex5(int value) {
        this.value = value;
    }

    @Override //но мы же сделали override
    public int next() {
        return 0;
    }

    public static void main(String[] args) {
        IntSequence seq = IntSequence.constant(3);
        while (seq.hasNext()){
            System.out.println(seq.next());
        }
    }


}

package com.horstmann.ch3.ex4;

public class ex4 implements IntSequence {
    private int[] args;

    public ex4(int[] args) {
        this.args = args;
    }

    @Override
    public boolean hasNext() {
        return args.length > 0;
    }

    @Override
    public int next() {
        int next = this.args[0];
        int[] argsSnaphot = new int[this.args.length - 1];
        System.arraycopy(args, 1, argsSnaphot, 0, this.args.length - 1);
        this.args = argsSnaphot;
        return next;
    }

    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(3, 4, 5, 6);
        while (seq.hasNext()){
            System.out.println(seq.next());
        }
    }
}

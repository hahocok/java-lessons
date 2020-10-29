package com.company;

public class Main {

    public static void main(String[] args) {

        final Monitor monitor = new Monitor(Chars.A);

        final Thread t1 = new Thread(new PrintingThread("A", Chars.A, monitor));
        final Thread t2 = new Thread(new PrintingThread("B", Chars.B, monitor));
        final Thread t3 = new Thread(new PrintingThread("C", Chars.C, monitor));

        t1.start();
        t2.start();
        t3.start();
    }
}
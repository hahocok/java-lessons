package com.company;

public class Main {

    public static void main(String[] args) {

        final MyMonitor pm = new MyMonitor(Chars.A);

        final Thread t1 = new Thread(new ThreatForPrint("A", Chars.A, pm));
        final Thread t2 = new Thread(new ThreatForPrint("B", Chars.B, pm));
        final Thread t3 = new Thread(new ThreatForPrint("C", Chars.C, pm));

        t1.start();
        t2.start();
        t3.start();
    }
}
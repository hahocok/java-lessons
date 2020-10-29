package com.company;

public class ThreatForPrint implements Runnable {
    private static final int COUNT = 5;

    final private String msg;
    final private Chars status;
    final private MyMonitor pm;

    public ThreatForPrint(String msg, Chars status, MyMonitor pm) {
        this.msg = msg;
        this.status = status;
        this.pm = pm;
    }

    @Override
    public void run() {
        synchronized (pm) {
            for (int i = 0; i < COUNT; ++i) {
                while (pm.getStatus() != status) {
                    try {
                        pm.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(msg);
                pm.setStatus(Chars.getNextStatus(status));
                pm.notifyAll();
            }
        }
    }
}

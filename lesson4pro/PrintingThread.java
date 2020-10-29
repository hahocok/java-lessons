package com.company;

public class PrintingThread implements Runnable {
    private static final int COUNT = 5;

    final private String msg;
    final private Chars status;
    final private Monitor monitor;

    public PrintingThread(String msg, Chars status, Monitor monitor) {
        this.msg = msg;
        this.status = status;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < COUNT; ++i) {
                while (monitor.getStatus() != status) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(msg);
                monitor.setStatus(Chars.getNextStatus(status));
                monitor.notifyAll();
            }
        }
    }
}

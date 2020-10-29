package com.company;

public class MyMonitor {
    private Chars status;

    public MyMonitor(Chars startStatus) {
        this.status = startStatus;
    }

    public Chars getStatus() {
        return status;
    }

    public void setStatus(Chars status) {
        this.status = status;
    }
}

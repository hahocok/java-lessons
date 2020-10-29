package com.company;

public class Monitor {
    private Chars status;

    public Monitor(Chars startStatus) {
        this.status = startStatus;
    }

    public Chars getStatus() {
        return status;
    }

    public void setStatus(Chars status) {
        this.status = status;
    }
}

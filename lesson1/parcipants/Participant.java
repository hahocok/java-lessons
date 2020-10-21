package com.company.parcipants;

public interface Participant {
    boolean run(int dis);
    boolean jump(int height);
    void info();
    void results();
    boolean isFinish();
    void setFinish();
}

package com.company;

public abstract class Animal {
    public int maxRunning;
    public float maxJump;
    public int maxSwim;

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public abstract void jump(int height);
}

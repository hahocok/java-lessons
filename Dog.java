package com.company;

public class Dog extends Animal {

    public Dog() {
        maxRunning = 100 * (int)(Math.random()*10);
        maxJump = 0.5f;
        maxSwim = 10;
    }

    public Dog(int maxRunning, float maxJump, int maxSwim) {
        this.maxRunning = maxRunning;
        this.maxJump = maxJump;
        this.maxSwim = maxSwim;
    }

    @Override
    public void run(int distance) {
        System.out.println("run: " + (distance <= maxRunning));
    }

    @Override
    public void swim(int distance) {
        System.out.println("swim: " + (distance <= maxJump));
    }

    @Override
    public void jump(int height) {
        System.out.println("jump: " + (height <= maxSwim));
    }
}
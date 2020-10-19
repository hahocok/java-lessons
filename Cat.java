package com.company;

public class Cat extends Animal {

    public Cat() {
        maxRunning = 200;
        maxJump = 2f;
        maxSwim = -1;
    }

    public Cat(int maxRunning, float maxJump, int maxSwim) {
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

package com.company;

import java.util.Random;

public class Dog extends Animal {
    //public int maxRunning = new Random().nextInt(1000);
    public int maxRunning = 100 * (int)(Math.random()*10);
    public float maxJump = 0.5f;
    public int maxSwim = 10;

    public Dog() {
    }

    public Dog(int maxRunning) {
        this.maxRunning = maxRunning;
    }

    @Override
    public void run(int distance) {
        System.out.println("run: " + (distance <= maxRunning));
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println("swim: " + (distance <= maxJump));
        super.swim(distance);
    }

    @Override
    public void jump(int height) {
        System.out.println("jump: " + (height <= maxSwim));
        super.jump(height);
    }
}
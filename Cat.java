package com.company;

public class Cat extends Animal {
    public int maxRunning = 200;
    public float maxJump = 2f;
    public int maxSwim = -1;

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

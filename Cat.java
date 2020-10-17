package com.company;

public class Cat extends Animal {
    public String name;
    public int maxRunning = 200;
    public float maxJump = 2f;
    public int maxSwim = -1;
    public int appetite = 1 + (int)(Math.random()*20);
    public boolean fullness = false;

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

    public void eat(Bowl bowl) {
        if (appetite > bowl.food) {
            fullness = true;
            bowl.food -= appetite;
        } else {
            System.out.println("В миске недостаточно еды");
        }
    }
}

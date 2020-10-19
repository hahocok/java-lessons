package com.company;

public class Cat extends Animal {
    private final String name;
    private final int APPETITE = 1 + (int)(Math.random()*20);
    public boolean fullness = false;

    public Cat(String name) {
        this.name = name;
        maxRunning = 200;
        maxJump = 2f;
        maxSwim = -1;
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

    public void eat(Bowl bowl) {
        if (APPETITE <= bowl.food) {
            fullness = true;
            bowl.food -= APPETITE;
        } else {
            System.out.println("В миске недостаточно еды");
            System.out.println(name + " не покушал");
            System.out.println("в миске " + bowl.food + " корма, а коту надо " + APPETITE);
            bowl.full();
        }
    }

    public String getName() {
        return name;
    }
}

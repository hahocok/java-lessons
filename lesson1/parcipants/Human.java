package com.company.parcipants;

import java.util.Random;

public class Human implements Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean finish;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 10 + (int)(Math.random()*40);
        this.maxJumpHeight = 10 + (int)(Math.random()*20);
    }

    @Override
    public boolean run(int dis) {
        if (dis <= maxRunDistance) {
            System.out.println(name + " успешно пробежал");
            return true;
        } else {
            System.out.println(name + " не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxRunDistance) {
            System.out.println(name + " успешно перепрыгнул");
            return true;
        } else {
            System.out.println(name + " не смог перепрыгнуть");
            return false;
        }
    }

    @Override
    public void info() {
        System.out.println("Имя: " + name + ", бегает " + maxRunDistance + ", прыгает " + maxJumpHeight);
    }

    @Override
    public void results() {
        if (finish) {
            System.out.println("Имя: " + name + " - прошел испытание");
        }
    }

    @Override
    public boolean isFinish() {
        return finish;
    }

    public void setFinish() {
        finish = true;
    }
}

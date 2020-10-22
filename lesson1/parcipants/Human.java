package com.company.parcipants;

public class Human implements Participant {
    private final String name;
    private final int maxRunDistance = 10 + (int)(Math.random()*40);
    private final int maxJumpHeight = 10 + (int)(Math.random()*20);
    private boolean finish;

    public Human(String name) {
        this.name = name;
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

    public void setFinish() {
        finish = true;
    }
}

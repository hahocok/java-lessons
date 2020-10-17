package com.company;

public class Bowl {
    public int volume;  //объем миски в условных единицах
    public int food;    //кол-во еды в условных единицах

    public Bowl() {
    }

    public Bowl(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int getVolume() {
        return volume;
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();
    private String name = "";

    public float getWeight() {
        if (fruits.size() > 0) {
            return fruits.size() * fruits.get(0).getWeight();
        }
        return 0f;
    }

    public void add(T fruit) {
        fruits.add(fruit);
        name = fruit.getClass().getSimpleName();
    }

    public void add(List<T> fruits) {
        if (fruits != null && !fruits.isEmpty()) {
            this.fruits.addAll(fruits);
            name = fruits.get(0).getClass().getSimpleName();
        }
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
    }

    public void removeAll() {
        fruits.clear();
    }

    public List<T> getAll() {
        return fruits;
    }

    public String getClassName() {
        return name;
    }

    public boolean compare(Box box) {
        return Float.compare(this.getWeight(), box.getWeight()) == 0;
    }

    public void pourInto(Box<T> box) {
        if (box != null && !fruits.isEmpty() &&
            box.getClassName().equals(getClassName())) {
            box.add(fruits);
            removeAll();
        }
    }

    public void print() {
        System.out.println(getClassName() + " - " + getWeight());
    }
}

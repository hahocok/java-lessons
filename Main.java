package com.company;

public class Main {

    public static void main(String[] args) {
        byte b =10;
        short s = 2404;
        int i = 123456;
        long l = 1500L;
        char c = 'A';
        float f = 120.0f;
        double d = 15.1231;
        boolean bool = true;
    }

    public int calc(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public boolean checkRange(int a, int b) {
        return a + b > 10 && a + b < 20;
    }

    public void checkNum(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public void printName(String name) {
        System.out.println("Привет, " + name);
    }

    public void year(int year) {
        if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}

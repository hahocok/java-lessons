package com.company;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);

        long timerStart = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        final long timerEnd = System.currentTimeMillis();
        System.out.println("calc time method1 = " + (timerEnd - timerStart) + "ms");
    }

    private static void method2() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Arrays.fill(arr, 1f);

        long timerStart = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; ++i) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; ++i) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        final long timerEnd = System.currentTimeMillis();
        System.out.println("calc time method2 = " + (timerEnd - timerStart) + "ms");
    }


}

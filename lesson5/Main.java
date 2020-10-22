package com.company;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);

        long timerStart = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = calcValue(arr[i], i);
        }

        final long timerEnd = System.currentTimeMillis();
        System.out.println("calc time method1 = " + (timerEnd - timerStart) + "ms");
    }

    private static void method2() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        Arrays.fill(arr, 1f);

        long timerStart = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; ++i) {
                    a1[i] = calcValue(a1[i], i);
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; ++i) {
                    a2[i] = calcValue(a2[i], i);
                }
            }
        };

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        final long timerEnd = System.currentTimeMillis();
        System.out.print("calc time method2 = " + (timerEnd - timerStart) + "ms");
    }

    private static float calcValue(float value, int i) {
        return  (float)(value * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}

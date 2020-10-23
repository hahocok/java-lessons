package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int FIRST_INDEX_TO_SWAP = 2;
    private static final int SECOND_INDEX_TO_SWAP = 4;

    public static void main(String[] args) {
        // 1
        print("\nЗадание 1");
        final String[] arr = {"1", "2", "3", "4", "5"};
        swapValueArr(arr, FIRST_INDEX_TO_SWAP, SECOND_INDEX_TO_SWAP);

        // 2
        print("\nЗадание 2");
        print("arr - " + arr.getClass().getSimpleName());
        print("arr changed - " + changeToArrayList(arr).getClass().getSimpleName());

        // 3
        print("\nЗадание 3");

        final Box<Apple>    appleBox1 = new Box<>();
        final Box<Orange>   orangeBox1 = new Box<>();
        final Box<Apple>    appleBox2 = new Box<>();
        final Box<Orange>   orangeBox2 = new Box<>();

        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());

        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());

        orangeBox2.add(new Orange());
        orangeBox2.add(new Orange());
        orangeBox2.add(new Orange());
        orangeBox2.add(new Orange());
        orangeBox2.add(new Orange());

        System.out.print("appleBox1 ");
        appleBox1.print();
        System.out.print("appleBox2 ");
        appleBox2.print();
        System.out.print("orangeBox1 ");
        orangeBox1.print();
        System.out.print("orangeBox2 ");
        orangeBox2.print();
        System.out.println("\n----------------------------------");

        System.out.println(appleBox1.compare(orangeBox2));
        System.out.println(orangeBox1.compare(appleBox1));

        System.out.println("пересыпаем из appleBox1 в appleBox2");
        appleBox1.pourInto(appleBox2);

        System.out.print("appleBox1 ");
        appleBox1.print();
        System.out.print("appleBox2 ");
        appleBox2.print();
    }

    private static <T> void swapValueArr(T[] arr, int firstIndex, int secondIndex) {
        if (
                arr != null &&
                firstIndex >= 0 && firstIndex < arr.length &&
                secondIndex >= 0 && secondIndex < arr.length
        ) {
            printArr(arr);
            print("после замены: ");
            T a = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = a;
            printArr(arr);
        }
    }

    private static <T> List<T> changeToArrayList(T[] arr) {
        return Arrays.asList(arr);
    }

    private static <T> void printArr(T[] arr) {
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private static void print(String str) {
        System.out.println(str);
    }
}

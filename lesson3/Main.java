package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //-------------
        // 1 задание  |
        //-------------
        System.out.println("Задание 1");

        String[] arr = genArr(20);
        printArr(arr);

        Map<String, Integer> duplicate = new HashMap<>();

        for (String s : arr) {
            int value = duplicate.getOrDefault(s, 0);
            duplicate.put(s, value + 1);
        }

        System.out.println("\n" + duplicate);
        System.out.println("--------------------------------------");

        //-------------
        // 2 задание  |
        //-------------
        System.out.println("Задание 2");

        Phonebook<String, String> phonebook = new Phonebook<>();

        phonebook.add("Jack", "+7 651 651 2323");
        phonebook.add("Jack", "+7 651 651 5409");
        phonebook.add("Charley", "+7 185 842 6871");
        phonebook.add("Charley", "+7 185 842 5632");
        phonebook.add("Thomas", "+7 946 384 2572");
        phonebook.add("Thomas", "+7 946 384 0943");
        phonebook.add("William", "+7 458 634 2898");
        phonebook.add("William", "+7 458 634 7542");
        phonebook.add("Daniel", "+7 391 279 6893");
        phonebook.add("Daniel", "+7 391 279 2485");
        phonebook.add("Henry", "+7 951 753 4589");
        phonebook.add("Henry", "+7 951 753 3674");
        phonebook.add("John", "+7 438 961 8567");
        phonebook.add("John", "+7 438 961 1458");

        String name = "William";
        System.out.println("\n" + name + ": " + phonebook.get(name));
        System.out.println("--------------------------------------");
    }

    private static String[] genArr(int size) {
        String[] origWord = new String[] {"Jack", "Charley", "Thomas", "William", "Daniel", "Henry", "John"};

        String[] out = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int position = random.nextInt(origWord.length);
            out[i] = origWord[position];
        }
        return out;
    }

    private static void printArr(String[] arr) {
        System.out.print("\n[ ");
        for (String str: arr) {
            System.out.print(str + " ");
        }
        System.out.print("]\n");
    }
}

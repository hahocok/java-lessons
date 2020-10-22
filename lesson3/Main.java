package com.company;

import java.util.*;

public class Main {
    private static final int ARRAY_SIZE = 20;
    private static final String SEARCHING_NAME = "William";

    public static void main(String[] args) {
        //-------------
        // 1 задание  |
        //-------------
        System.out.println("Задание 1");

        final String[] wordsArray = genArr();
        printArr(wordsArray);

        final Map<String, Integer> duplicate = new HashMap<>();

        for (String s : wordsArray) {
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

        printResult(phonebook);
    }

    private static void printResult(Phonebook<String, String> phonebook) {
        final Set<String> phones = phonebook.get(SEARCHING_NAME);

        System.out.print("\n" + SEARCHING_NAME + ": ");

        for (Iterator<String> it = phones.iterator(); it.hasNext(); ) {
            String phone = it.next();
            System.out.print(phone);
            if (it.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("\n--------------------------------------");
    }

    private static String[] genArr() {
        final String[] origWord = new String[] {"Jack", "Charley", "Thomas", "William", "Daniel", "Henry", "John"};

        final String[] out = new String[ARRAY_SIZE];
        final Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
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

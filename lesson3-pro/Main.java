package com.company;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1
        System.out.println("Задание 1");
        final String filename = "src/com/company/text.txt";

        printFile(filename);

        // 2
        System.out.println("Задание 2");
        final ArrayList<InputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("src/com/company/text.txt"));
        ali.add(new FileInputStream("src/com/company/text2.txt"));
        ali.add(new FileInputStream("src/com/company/text3.txt"));
        ali.add(new FileInputStream("src/com/company/text4.txt"));
        ali.add(new FileInputStream("src/com/company/text5.txt"));
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));

        final List<byte[]> allData = new ArrayList<>();

        byte[] buff = new byte[4096];
        int length;
        while ((length = in.read(buff)) != -1) {
            byte[] data = new byte[length];
            System.arraycopy(buff, 0, data, 0, length);
            allData.add(data);
        }

        final String fileFoSave = "src/com/company/textAll.txt";

        try(FileOutputStream fos = new FileOutputStream(fileFoSave)) {
            for (byte[] data : allData) {
                fos.write(data);
            }
        }

        printFile(fileFoSave);

        // 3
        System.out.println("Задание 3");

        final int EXIT_NUMBER = -1;
        int page = -1;
        final String fileName1 = "src/com/company/textPages.txt";
        final int PAGE_SIZE = 5;

        try(RandomAccessFile raf = new RandomAccessFile(fileName1, "r")) {
            final long MAX_PAGE = raf.length() / PAGE_SIZE;
            byte[] buffer = new byte[PAGE_SIZE];

            do {
                System.out.println("Введите -1 для выхода");
                System.out.println("Введите номер старницы [1 - " + (MAX_PAGE) + "]:");
                final Scanner scanner = new Scanner(System.in);

                page = scanner.nextInt();

                if (page > 0 && page <= MAX_PAGE) {
                    int position = (page - 1) * PAGE_SIZE;
                    raf.seek(position);
                    raf.read(buffer);

                    System.out.println(new String(buffer));
                }
            } while (page > EXIT_NUMBER);
        }
    }

    private static void printFile(String filename) {
        try (FileInputStream in = new FileInputStream(filename)){
            byte[] buff = new byte[4096];
            int x;

            while ((x = in.read(buff)) > 0) {
                System.out.print(new String(buff, 0 , x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}

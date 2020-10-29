package com.company;

public class Main {
    private static final int MAX_ARR_SIZE = 4;

    public static void main(String[] args) {
        String[][] arrs = new String[MAX_ARR_SIZE][MAX_ARR_SIZE];

        fillArr(arrs);
        try {
            checkArr(arrs);
            int sum = getSum(arrs);
            System.out.println("Сумма - " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkArr(String[][] arrs) throws MySizeArrayException {
        if (arrs.length != MAX_ARR_SIZE || arrs[0].length != MAX_ARR_SIZE) {
            throw new MySizeArrayException(MAX_ARR_SIZE);
        }
    }

    private static int getSum(String[][] arrs) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                try {
                    sum += Integer.parseInt(arrs[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arrs[i][j]);
                }
            }
        }
        return sum;
    }

    public static void fillArr(String[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                arrs[i][j] = Integer.toString(j);
            }
        }
    }
}

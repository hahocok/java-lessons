package com.company;

public class Main {

    public static void main(String[] args) {
        String[][] arrs = new String[4][4];

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
        if (arrs.length > 4 || arrs[0].length > 4) {
            throw new MySizeArrayException(4);
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

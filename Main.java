package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        int[] nums1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        for (int i = 0; i <= nums1.length - 1; i++) {
            if (nums1[i] == 1) {
                nums1[i] = 0;
            } else {
                nums1[i] = 1;
            }
        }

        /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        int[] nums2 = new int[8];

        for (int i = 0; i <= nums2.length - 1; i++) {
            nums2[i] += i * 3;
        }

        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        пройти по нему циклом, и числа, меньшие 6, умножить на 2;
         */
        int[] nums3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i <= nums3.length -1; i++) {
            if (nums3[i] < 6) {
                nums3[i] *= 2;
            }
        }

        /*
        4. Создать квадратный двумерный целочисленный массив
        (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        заполнить его диагональные элементы единицами;
         */
        int[][] nums4 = new int[4][4];

        for (int i = 0, j = nums4.length - 1; i <= nums4.length - 1; i++, j--) {
            nums4[i][i] = 1;
            nums4[j][j] = 1;
        }
    }

    /*
    5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public void minMax(int[] nums5) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= nums5.length - 1; i++) {
            if (nums5[i] < min) {
                min = nums5[i];
            }
            if (nums5[i] > max) {
                max = nums5[i];
            }
        }
    }

    /*
    6. Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;
     */
    public boolean checkBalance(int[] nums6) {
        int sumLeft = 0;
        int sumRight = 0;

        boolean odd = nums6.length % 2 != 0;
        int half = nums6.length / 2;

        for (int i = 0, j = nums6.length - 1; i <= half; i++, j--) {
            sumLeft += nums6[i];
            if (!(odd && i == half))
                sumRight += nums6[j];
        }

        return sumLeft == sumRight;
    }

    /*
    7. *Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным или отрицательным), при этом метод должен сместить все элементы
    массива на n позиций. Нельзя пользоваться вспомогательными массивами.
     */
    public static void method7(int[] nums7, int quantity) {
        int n = Math.abs(quantity);
        for (int i = 0; i != n; i++) {
            for (int j = 0; j <= nums7.length; j++) {
                nums7[j] = nums7[j + 1];
            }
        }
    }
}

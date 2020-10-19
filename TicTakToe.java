package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTakToe {
    /*
    блок настроек игры
     */

    private static char[][] map;                    //матрица игры
    private static final int SIZE = 3;              //размерность поля

    private static final char DOT_EMPTY = '◦';      //пустой символ
    private static final char DOT_X = 'X';          //крестик
    private static final char DOT_O = 'O';          //нолик

    private static final boolean SILLY_MODE = false;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static boolean firstTurn = true;

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();    //ход человека
            if (isEndGame(DOT_X)) {
                break;
            }
            computerTurn(); //ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }
        }
    }

    /**
     * Метод инициализации карты
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод отрисовки карты
     */
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");                      //нумерация строк

            for (int j = 0; j < SIZE; j++) {
                if (i == 0) {
                    System.out.print((j + 1) + " ");        //нумерация столбцов
                } else {
                    System.out.print(map[i - 1][j] + " ");  //отрисовка поля
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Ход человека
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }while (!isCellValid(x,y));

        map[x][y] = DOT_X;
    }


    /**
     * Ход компьютера
     */
    private static void computerTurn() {
        int x = -1;
        int y = -1;

        int[][] mapCellPrice = new int[SIZE][SIZE];

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            do {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        mapCellPrice[i][j] = calcPriceCells(i, j);      //проверяем клетки по направлениям присваивая ценность
                    }
                }
                int[] result = nextTurn(mapCellPrice);
                x = result[0];
                y = result[1];
            } while (!isCellValid(x, y));
        }

        System.out.println("Компьютер выбрал ячейку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }

    /**
     * Метод расчета следующего хода
     * @param mapCellPrice - массив ценности ячеек
     * @return координаты следующего хода
     */
    private static int[] nextTurn(int[][] mapCellPrice) {
        int[][] turns = new int[10][];                          //массив для хранения возможных ходов
        int countTurns = 0;                                     //кол-во возможных ходов
        int maxPrice = -1;                                      //максимальная ценность

        clearTurns(turns);

        for (int i = 0; i < mapCellPrice.length; i++) {
            for (int j = 0; j < mapCellPrice.length; j++) {

                if (firstTurn) {
                    int x;
                    int y;
                    firstTurn = false;
                    do {
                        x = random.nextInt(SIZE);
                        y = random.nextInt(SIZE);
                    } while (!isCellValid(x, y));
                    return new int[]{x, y};
                }

                if (mapCellPrice[i][j] > maxPrice && isCellValid(i, j)) {
                    maxPrice = mapCellPrice[i][j];
                    countTurns = 1;
                    clearTurns(turns);
                    turns[countTurns - 1] = new int[]{i, j};
                } else if (mapCellPrice[i][j] == maxPrice && isCellValid(i, j)) {
                    countTurns++;
                    turns[countTurns - 1] = new int[]{i, j};
                }

            }
        }

//        printMapPriceDebug(mapCellPrice);

        return turns[random.nextInt(countTurns)];
    }

    private static void clearTurns(int[][] arr) {
        for (int[] ints : arr) {
            ints = new int[2];
            Arrays.fill(ints, -1);
        }
    }

    /**
     * Метод отрисовки карты ценности ячеек
     * @param arr - массив, содержащий карту ценности ячеек
     */
    private static void printMapPriceDebug(int[][] arr) {
        System.out.println("------- debug -------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    /**
     * Метод расчитывающий ценность ячейки(анализирует только ближайшие клетки)
     * @param x - координата по вертикали
     * @param y - координата по горизонтали
     * @return возвращает ценность ячейки
     */
    private static int calcPriceCells(int x, int y) {
        int price = -1;

        if (map[x][y] != DOT_EMPTY) return price;

        if (checkCell(x , y - 1)) {
            if (map[x][y - 1] == DOT_O) price++;
        }
        if (checkCell(x - 1 , y)) {
            if (map[x - 1][y] == DOT_O) price++;
        }
        if (checkCell(x + 1 , y)) {
            if (map[x + 1][y] == DOT_O) price++;
        }
        if (checkCell(x , y + 1)) {
            if (map[x][y + 1] == DOT_O) price++;
        }

        if (isCorner(x, y) || isMid(x, y)) {
            if (checkCell(x - 1 , y - 1)) {
                if (map[x - 1][y - 1] == DOT_O) price++;
            }
            if (checkCell(x - 1 , y + 1)) {
                if (map[x - 1][y + 1] == DOT_O) price++;
            }
            if (checkCell(x + 1 , y - 1)) {
                if (map[x + 1][y - 1] == DOT_O) price++;
            }
            if (checkCell(x + 1 , y + 1)) {
                if (map[x + 1][y + 1] == DOT_O) price++;
            }
        }

        return price;
    }

    /**
     * Метод анализирующий является ли ячейка центром поля
     * @param x - координата по вертикали
     * @param y - координата по горизонтали
     * @return возвращает true если ячейка находится по центру поля
     */
    private static boolean isMid(int x, int y) {
        return x == 1 && y == 1;                    //TODO сделать нормальную проверку
    }

    /**
     * Метод проверяющий угловая ли ячейка
     * @param x - координата по вертикали
     * @param y - координата по горизонтали
     * @return boolean - true если угол
     */
    private static boolean isCorner(int x, int y) {
        return (x == 0) && (y == 0) ||
                (x == SIZE -1) && (y == 0) ||
                (x == 0) && (y == SIZE - 1) ||
                (x == SIZE - 1) && (y == SIZE - 1)
                ;
    }

    /**
     * Проверка, попадают ли координаты в поле
     * @param x - координата по вертикали
     * @param y - координата по горизонтали
     * @return возвращает true если координата в пределах поля
     */
    private static boolean checkCell(int x, int y) {
        return (x >= 0 && x <= SIZE - 1) && (y >= 0 && y <= SIZE - 1);
    }

    /**
     * Метод проверки валидности ячейки для хода
     * @param x - координата по вертикали
     * @param y - координата по горизонтали
     * @return result - валидность ячейки
     */
    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        //проверка координаты
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("за полем");
            result = false;
        }

        //проверка заполнености ячейки
        if (map[x][y] != DOT_EMPTY) {
            System.out.println("ячейка заполнена");
            result = false;
        }

        return result;
    }

    /**
     * Метод проверяет закончена ли игра
     * @param playerSymbol символ игрока, для которого выполняется проверка
     * @return возвращает true если игра окончена
     */
    private static boolean isEndGame(char playerSymbol) {

        printMap();

        //проверяем необходимость следующего хода
        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            return true;
        }

        //проверка заполненности поля
        if (isMapFull()) {
            System.out.println("Ничья");
            return true;
        }

        return false;
    }

    /**
     * Метод проверки выигрыша
     * @param playerSymbol - символ пользователя
     * @return boolean - результат проверки
     */
    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][1] == playerSymbol && map[2][0] == playerSymbol)
        ) {
            result = true;
        }

        return result;
    }

    /**
     * Метод проверки заполнености поля на 100%
     * @return boolean - результат проверки
     */
    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            /*  использую переменную result как ориентир на актуальность цикла
                прерывает цикл если result == false
             */
            if (result) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        result = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }
}
package com.company;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j, String data) {
        super("Ошибочные данные в ячейке [" + i + "][" + j + "]{" + data + "}");
    }
}

package com.company;

public class MySizeArrayException extends Exception {
    public MySizeArrayException(int size) {
        super("неправильный размер массива, допустимый размер " + size + "x" + size);
    }
}

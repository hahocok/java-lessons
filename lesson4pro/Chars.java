package com.company;

public enum Chars {
    A,
    B,
    C;

    public static Chars getNextStatus(Chars currentStatus) {
        final int position = currentStatus.ordinal();
        final int next = (position + 1) % Chars.values().length;
        return Chars.values()[next];
    }
}

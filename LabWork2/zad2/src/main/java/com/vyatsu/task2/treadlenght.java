package com.vyatsu.task2;

public enum treadlenght {
    LONG(3), MIDDLE(2), SHORT(1);
    private int long1;

    treadlenght(int long1) {
        this.long1 = long1;
    }

    public int getLong1() {
        return long1;
    }
}

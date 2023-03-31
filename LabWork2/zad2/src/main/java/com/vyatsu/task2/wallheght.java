package com.vyatsu.task2;

public enum wallheght {
    big(3), standart1(2), small(1);

    private int heght;
    wallheght(int heght)
    {
        this.heght = heght;
    }
    public int getHeght()
    {
        return heght;
    }
}

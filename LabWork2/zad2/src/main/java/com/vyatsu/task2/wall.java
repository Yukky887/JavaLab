package com.vyatsu.task2;

public class wall extends obtacles {
    private wallheght height;
    public wall(wallheght height) {
        this.height = height;
    }
    @Override
    public boolean contest(contestants contestant) { return contestant.jump(height.getHeght());}
}

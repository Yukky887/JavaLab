package com.vyatsu.task2;

public class threadmill extends obtacles
{
    private treadlenght aLong;

    public threadmill(treadlenght aLong) {
        this.aLong = aLong;
    }
    @Override
    public boolean contest(contestants contestant) { return contestant.run(aLong.getLong1());}
}

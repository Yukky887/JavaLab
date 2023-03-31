package com.vyatsu.task2;

public class human extends contestants implements runable, jumpable{
    String name;
    @Override
    public boolean run(int distance){
        if (distance <= 2) {
            System.out.println("Человек " + name + " пробежал дистанцию " + distance);
            return true;
        }
        else{
            System.out.println("Человек " + name + " не справился с дистанцией " + distance);
            return false;
        }


    }
    @Override
    public boolean jump(int distance){
        if (distance <= 2) {
            System.out.println("Человек " + name + " прыгнул через препятствие " + distance);
            return true;
        }
        else{
            System.out.println("Человек " + name + " не справился с высотой " + distance);
            return false;
        }
    }

    public human(String name) {
        this.name = name;
    }
}

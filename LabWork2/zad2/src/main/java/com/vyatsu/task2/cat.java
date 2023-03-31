package com.vyatsu.task2;

public class cat extends contestants implements runable, jumpable{
    String name;
    @Override
    public boolean run(int distance){
        if (distance <= 1) {
            System.out.println("Кот " + name + " пробежал дистанцию " + distance);
            return true;
        }
        else{
            System.out.println("Кот " + name + " не справился с дистанцией " + distance);
            return false;
        }

    }
    @Override
    public boolean jump(int distance){
        if (distance <= 3) {
            System.out.println("Кот " + name + " прыгнул через препятствие " + distance);
            return true;
        }
        else{
            System.out.println("Кот " + name + " не справился с высотой " + distance);
            return false;
        }
    }

    public cat(String name) {
        this.name = name;
    }
}

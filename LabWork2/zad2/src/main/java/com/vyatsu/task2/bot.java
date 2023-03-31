package com.vyatsu.task2;

public class bot extends contestants implements jumpable, runable {
    String name;
    private static int counter = 0;

    @Override
    public boolean run(int distance){
        if (distance <= 1) {
            System.out.println("Робот " + name + " пробежал дистанцию " + distance);
            return true;
        }
        else
        {
            if(counter <= 1)
            {
                System.out.println("Ульта. Робот " + name + " пробежал дистанцию " + distance);
                counter++;
                return true;
            }
            System.out.println("Робот " + name + " не пробежал дистанцию " + distance);
            return false;
        }
    }
    @Override
    public boolean jump(int distance){
        if (distance <= 1) {
            System.out.println("Робот " + name + " прыгнул через препятствие " + distance);
            return true;
        }
        else
        {
            if(counter <= 1)
            {
                System.out.println("Ульта. Робот " + name + " прыгнул через препятствие " + distance);
                counter++;
                return true;
            }
            System.out.println("Робот " + name + " не справился с высотой " + distance);
            return  false;
        }
    }

   /* public boolean ult(int distance,int psixanyl)
    {
        if (distance <=1);
        {
            System.out.println("Ульта");
            distance = 2000;
            System.out.println("Робот " + name + " перепрыгнул" + distance);
            return true;
        }
    }*/

    public bot(String name) {
        this.name = name;
    }
}

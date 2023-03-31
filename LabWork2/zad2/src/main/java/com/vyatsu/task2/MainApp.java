package com.vyatsu.task2;

public class MainApp {
    public static void main(String[] args) {
        obtacles[] obstacle =
                {
                        new threadmill(treadlenght.LONG),
                        new wall(wallheght.small),
                        new wall(wallheght.big),
//                        new wall(wallheght.big),

                        new threadmill(treadlenght.LONG),


                };
        contestants[] contestant = {
                new bot("R2D2"),
                new bot("CHAPPI"),
                new bot("Dima"),
                new human("Вадим"),
                new cat("Котопес"),
        };
        for (contestants c : contestant) {
            for (obtacles o : obstacle) {
                if (!o.contest(c)) {
                    break;
                }

            }

        }

    }
}

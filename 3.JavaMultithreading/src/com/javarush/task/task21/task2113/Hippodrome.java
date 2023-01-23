package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Jane", 3, 0));
        game.getHorses().add(new Horse("Anna", 3, 0));
        game.getHorses().add(new Horse("Dianosauric", 3, 0));
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner()
    {   Horse winerHorse = horses.get(0);
        for (Horse horse: horses) {
            if (horse.getDistance() > winerHorse.getDistance())
                winerHorse = horse;
        }
        return winerHorse;
    }
    public void printWinner()
    {
        System.out.printf("Winner is %s!",getWinner().getName());
    }

}

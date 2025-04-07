package hw4.task2;

import hw4.task2.game.Hammer;
import hw4.task2.game.Human;

public class HammerGameSimulation {
    public static void main(String[] args) {
        Hammer hammer = new Hammer();

        Thread human1 = new Thread(new Human(hammer, "Human1", true), "Thread-Human1");
        Thread human2 = new Thread(new Human(hammer, "Human2", false), "Thread-Human2");

        human1.start();
        human2.start();

        System.out.println("Игра началась! Человечки по очереди стучат молотком.");
    }
}

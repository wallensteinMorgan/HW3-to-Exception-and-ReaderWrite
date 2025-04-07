package hw4.task2.game;

public class Human implements Runnable{
    private final Hammer hammer;
    private final String name;
    private final boolean isFirst;

    public Human(Hammer hammer, String name, boolean isFirst) {
        this.hammer = hammer;
        this.name = name;
        this.isFirst = isFirst;
    }

    @Override
    public void run() {
        while (true) {
            if (isFirst) {
                hammer.hitByHuman1(name);
            } else {
                hammer.hitByHuman2(name);
            }
        }
    }
}

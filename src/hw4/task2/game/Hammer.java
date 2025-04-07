package hw4.task2.game;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hammer {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean isHuman1Turn = true;

    public void hitByHuman1(String name) {
        lock.lock();
        try {
            while (!isHuman1Turn) {
                condition.await();
            }
            System.out.println(name + " ударил молотком!");
            isHuman1Turn = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void hitByHuman2(String name) {
        lock.lock();
        try {
            while (isHuman1Turn) {
                condition.await();
            }
            System.out.println(name + " ударил молотком!");
            isHuman1Turn = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

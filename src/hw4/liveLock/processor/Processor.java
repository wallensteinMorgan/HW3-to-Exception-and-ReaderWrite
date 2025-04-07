package hw4.liveLock.processor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {
    private final Lock lock = new ReentrantLock();
    private boolean isProcessing = false;

    public boolean tryProcessMessage() {
        if (lock.tryLock()) {
            try {
                isProcessing = true;
                System.out.println(Thread.currentThread().getName() + ": начал обработку сообщения");
                Thread.sleep(500);
                isProcessing = false;
                System.out.println(Thread.currentThread().getName() + ": завершил обработку сообщения");
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean isBusy() {
        return isProcessing;
    }
}

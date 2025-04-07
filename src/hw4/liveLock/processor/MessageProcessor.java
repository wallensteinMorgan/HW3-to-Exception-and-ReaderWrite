package hw4.liveLock.processor;

public class MessageProcessor {
    public static void startProcessorA(Processor processorA, Processor processorB) {
        Thread threadA = new Thread(() -> {
            while (true) {
                if (processorB.isBusy()) {
                    System.out.println("Процессор A: процессор B занят, откладываю обработку");
                } else {
                    processorA.tryProcessMessage();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Processor-A");

        threadA.start();
    }

    public static void startProcessorB(Processor processorA, Processor processorB) {
        Thread threadB = new Thread(() -> {
            while (true) {
                if (processorA.isBusy()) {
                    System.out.println("Процессор B: процессор A занят, откладываю обработку");
                } else {
                    processorB.tryProcessMessage();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Processor-B");

        threadB.start();
    }
}

package hw4.liveLock;

import hw4.liveLock.processor.MessageProcessor;
import hw4.liveLock.processor.Processor;

public class MessageProcessingSimulation {
    public static void main(String[] args) {
        Processor processorA = new Processor();
        Processor processorB = new Processor();

        MessageProcessor.startProcessorA(processorA, processorB);
        MessageProcessor.startProcessorB(processorA, processorB);

        System.out.println("Программа запущена. Наблюдайте за выводом.");
    }
}

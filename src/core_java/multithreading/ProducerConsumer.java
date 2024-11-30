package core_java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY = 5; // Define the capacity of the buffer
    private final Queue<Integer> buffer = new LinkedList<>(); // Shared buffer
    private final Object lock = new Object(); // Lock object for synchronization

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producerThread = new Thread(pc.new Producer(), "Producer");
        Thread consumerThread = new Thread(pc.new Consumer(), "Consumer");
        producerThread.start();
        consumerThread.start();
    }

    // Producer class
    class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;

                synchronized (lock) {
                    while (buffer.size() == CAPACITY) {
                        try {
                            lock.wait(); // Wait if buffer is full
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Producer interrupted");
                        }
                    }
                    buffer.offer(value); // Produce data
                    System.out.println("Produced: " + value);
                    value++;
                    lock.notify(); // Notify consumer that buffer is not empty
                }

        }
    }

    // Consumer class
    class Consumer implements Runnable {
        @Override
        public void run() {

                synchronized (lock) {
                    while (buffer.isEmpty()) {
                        try {
                            lock.wait(); // Wait if buffer is empty
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Consumer interrupted");
                        }
                    }
                    int value = buffer.poll(); // Consume data
                    System.out.println("Consumed: " + value);
                    lock.notify(); // Notify producer that buffer is not full
                }

        }
    }
}


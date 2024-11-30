package core_java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer_practice {

    private static final int CAPACITY = 3;

    private final Queue<Integer> buffer = new LinkedList<>();

    public synchronized void produce(int data) {

        while(buffer.size() == CAPACITY){
            System.out.println("producer went to waiting state as buffer is full");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        buffer.offer(data);
        System.out.println("produced : " + data);
        notify(); // notify the waiting consumer that buffer is now having value
    }

    public synchronized void consume() {

        while(buffer.isEmpty()){
            System.out.println("consumer went to waiting state as buffer is empty");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Integer item = buffer.poll();
        System.out.println("consumed : " + item);
        notify(); // notify the waiting producer that buffer is now ready to take values


    }

    public static void main(String[] args) {
        ProducerConsumer_practice pc = new ProducerConsumer_practice();

        Thread producer = new Thread(() -> {
            for(int i=1; i<=6; i++){
               pc.produce(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for(int i=1; i<=6; i++){
                pc.consume();
            }
        });

        producer.start();
        consumer.start();
    }

}

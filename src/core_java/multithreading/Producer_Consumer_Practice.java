package core_java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class Producer_Consumer_Practice {

    static final int  CAPACITY = 3;
    Queue<Integer> buffer = new LinkedList<>();


    public static void main(String[] args) {
        Producer_Consumer_Practice pc = new Producer_Consumer_Practice();


        Thread t1 = new Thread(() -> {
           for(int i=1; i<=6; i++) {
               try {
                   pc.publish(i);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i=1; i<=6; i++) {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();


    }


    public synchronized void publish(int i) throws InterruptedException {

        if(buffer.size() == CAPACITY){
            System.out.println("waiting as buffer is full");
            wait();
        }

        buffer.offer(i);
        System.out.println("published : " + i);
        notify();// notify to waiting thread to start consuming

    }

    public synchronized void consume() throws InterruptedException {
        if(buffer.isEmpty()){
            System.out.println("waiting as buffer is empty");
            wait();
        }
        Integer item = buffer.poll();
        System.out.println("consumed : " + item);
        notify();// notify to waiting thread to start producing
    }

}

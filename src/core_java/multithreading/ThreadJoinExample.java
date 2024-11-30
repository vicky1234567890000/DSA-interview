package core_java.multithreading;

import java.util.stream.IntStream;

public class ThreadJoinExample {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            for(int i=0; i<10; i++)
              System.out.println(Thread.currentThread().getName());
        });
        t.start();
        t.join();

        IntStream.rangeClosed(1,10).forEach((x) -> System.out.println(Thread.currentThread().getName()));
    }
}

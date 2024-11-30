package core_java.multithreading;

import java.util.stream.IntStream;

// Daemon thread is alive till any one of the user thread is alive.
public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            IntStream.rangeClosed(1,10).forEach((x) -> System.out.println(Thread.currentThread().getName()));
        });
        t.setDaemon(true);
        t.start();
        IntStream.rangeClosed(1,1).forEach((x) -> System.out.println(Thread.currentThread().getName()));
    }
}

package core_java.multithreading;

import java.util.stream.IntStream;

public class ThreadJoinExample2 {
    public static void main(String[] args) {

        ChildThread.mainThread = Thread.currentThread();
        ChildThread ct = new ChildThread();
        Thread t = new Thread(ct);
        t.start();

        IntStream.rangeClosed(1,10).forEach((x) -> System.out.println(Thread.currentThread().getName()));
    }
}

class ChildThread implements Runnable {

    static Thread mainThread;
    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        IntStream.rangeClosed(1,10).forEach((x) -> System.out.println(Thread.currentThread().getName()));
    }
}
package java8_finalprep;

public class PrintEvenOddUsingTwoThreadsTraditionally implements Runnable {
    static int count = 0;
    Object object;

    public PrintEvenOddUsingTwoThreadsTraditionally(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {

        Object lock = new Object();
        PrintEvenOddUsingTwoThreadsTraditionally r1 = new PrintEvenOddUsingTwoThreadsTraditionally(lock);
        PrintEvenOddUsingTwoThreadsTraditionally r2 = new PrintEvenOddUsingTwoThreadsTraditionally(lock);

        Thread t1 = new Thread(r1, "even");

        Thread t2 = new Thread(r2,"odd");

        t1.start();

        t2.start();

    }

    @Override
    public void run() {

        while (count < 10) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(count + " is printed by " + Thread.currentThread().getName());
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(count + " is printed by " + Thread.currentThread().getName());
                    count++;
                    object.notify();
                }
            }

        }


    }
}

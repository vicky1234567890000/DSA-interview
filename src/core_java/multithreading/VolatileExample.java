package core_java.multithreading;

public class VolatileExample {

    private static volatile boolean flag = true;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int count = 1;
            while(!flag && count <= 10){
                System.out.println("volatile concept understood");
                count ++;
            }
            System.out.println("Thread 1 completed");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag = false;
            System.out.println("Thread 2 completed");
        });

        t1.start();
        t2.start();

    }
}

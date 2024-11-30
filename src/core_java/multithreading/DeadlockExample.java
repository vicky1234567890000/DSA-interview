package core_java.multithreading;

public class DeadlockExample {

    public static void main(String[] args) {
        final ResourceA resourceA = new ResourceA();
        final ResourceB resourceB = new ResourceB();

        // Thread 1 tries to lock resourceA then resourceB
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("Thread 1: Locked resource A");

                    try { Thread.sleep(50); } catch (InterruptedException e) {}

                    synchronized (resourceB) {
                        System.out.println("Thread 1: Locked resource B");
                    }
                }
            }
        });

        // Thread 2 tries to lock resourceB then resourceA
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceB) {
                    System.out.println("Thread 2: Locked resource B");

                    try { Thread.sleep(50); } catch (InterruptedException e) {}

                    synchronized (resourceA) {
                        System.out.println("Thread 2: Locked resource A");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

class ResourceA {
    // Some fields and methods
}

class ResourceB {
    // Some fields and methods
}


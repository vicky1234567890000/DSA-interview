package core_java.multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {

        ThreadDemo threadDemo = new ThreadDemo();
        Thread t = new Thread(threadDemo);
        t.start();
        //Thread.sleep(10000);
        synchronized (t) {
            t.wait(10000);
        }
        System.out.println(threadDemo.total);

    }

}

class ThreadDemo implements Runnable{
    int total = 0;

    @Override
    public void run() {

        synchronized (this){
            for(int i=0; i<=100; i++){
                total += i;
            }
            this.notify();
        }
    }
}



package core_java.multithreading;

public class PrintSum {
    public static void main(String[] args) throws InterruptedException {
        TotalCalculator totalCalculator = new TotalCalculator();
        Thread t = new Thread(totalCalculator);
        t.start();

        synchronized (t){
            t.wait();
        }

        System.out.println(totalCalculator.total);
    }
}
class TotalCalculator implements Runnable{

    public int total;

    @Override
    public void run() {




        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                total += i;
            }
            this.notify();
        }
    }
}

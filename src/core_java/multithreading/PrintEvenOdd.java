package core_java.multithreading;

public class PrintEvenOdd implements Runnable{

    static int count = 1;
    Object obj;


    public PrintEvenOdd(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {

        Object lock = new Object();
        PrintEvenOdd r1 = new PrintEvenOdd(lock);
        PrintEvenOdd r2 = new PrintEvenOdd(lock);

        new Thread(r1, "even").start();

        new Thread(r2, "odd").start();



    }

    @Override
    public void run() {

        while (count <=10 ){

            if(count % 2 == 0 && Thread.currentThread().getName().equals("even")){
                synchronized (obj){
                    System.out.println(count + " - printed by thread:" + Thread.currentThread().getName());
                    count++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


            if(count % 2 != 0 && Thread.currentThread().getName().equals("odd")){
                synchronized (obj){
                    System.out.println(count + " - printed by thread:" + Thread.currentThread().getName());
                    count++;
                    obj.notify();
                }
            }
        }

    }
}

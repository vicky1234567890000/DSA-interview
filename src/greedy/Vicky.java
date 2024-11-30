package greedy;

public class Vicky implements Runnable{
    @Override
    public void run() {
        System.out.println("run.");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Vicky());
        t.start();
        System.out.println("End of method.");
    }
}

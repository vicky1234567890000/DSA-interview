package core_java.multithreading;

public class A {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(() -> a.m1(b));
        Thread t2 = new Thread(() -> b.m2(a));
        t1.start();
        t2.start();
    }

    synchronized public void m1(B b)  {
        System.out.println("m1() is executed by : " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        b.common();
    }

    synchronized public void common(){
        System.out.println("A class common executed");
    }
}

class B {
    synchronized public void m2(A a){
        System.out.println("m2() is executed by : " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a.common();
    }

    synchronized public void common(){
        System.out.println("B class common executed");
    }

}


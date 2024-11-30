package core_java.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/*

IMP NOTE : Locking do not depend on object like synchronization.

Reentrant means a thread can acquire same lock multiple times without any issue.
Internally Reentrant lock increments thread's personal count whenever we call lock()
and decrements count value whenever thread calls unlock() .
lock will be released , when count reaches 0.

ReentrantLock l = new ReentrantLock(); // creates an instance of ReentrantLock.
ReentrantLock l = new ReentrantLock(boolean fairness); // creates an instance of ReentrantLock with given fairness policy

If the fairness is true, the longest waiting thread can acquire the lock if it's available. It serves FCFS policy.
If the fairness is false, which waiting thread will get the chance we can not predict.
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock l = new ReentrantLock();
        ReentrantLockDemo reentrantLockDemo1 = new ReentrantLockDemo();
        ReentrantLockDemo reentrantLockDemo2 = new ReentrantLockDemo();
        Thread t1 = new Thread(() -> {
            try {
                reentrantLockDemo1.print(l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                reentrantLockDemo2.print(l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

    }

    public void print(ReentrantLock lock) throws InterruptedException {

        try {
            lock.lock();
            System.out.println("lock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(10000);
        }
        catch(Exception e){
            // handle exception
        }
        finally {
            lock.unlock();
            System.out.println("lock released by : " + Thread.currentThread().getName());
        }
    }
}

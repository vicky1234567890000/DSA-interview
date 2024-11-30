package core_java.multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
readlock = more than one thread can acquire readlock (shared lock)
writelock = one thread can acquire writelock (exclusive lock)

exclusive lock will not be executed until shared locked are executed.

ReadWriteLock should be used then when read requests are very high compared to write requests.
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {

        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {
            readWriteLockDemo.produce(lock);
        });

        Thread t2 = new Thread(() -> {
            readWriteLockDemo.produce(lock);
        });

        ReadWriteLockDemo readWriteLockDemo1 = new ReadWriteLockDemo();
        Thread t3 = new Thread(() -> {
            readWriteLockDemo1.consume(lock);
        });

        t1.start();
        t2.start();
        t3.start();


    }

    public void produce(ReadWriteLock lock) {
        System.out.println("lock acquired by producer of thread " + Thread.currentThread().getName());
        lock.readLock().lock();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally{
            System.out.println("lock released by producer of thread " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }

    }

    public void consume(ReadWriteLock lock) {
        System.out.println("lock acquired by consumer of thread " + Thread.currentThread().getName());
        lock.writeLock().lock();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally{
            System.out.println("lock released by consumer of thread " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }

    }
}

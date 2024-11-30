package core_java.multithreading;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4
                ,10, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2)
        ,new CustomThreadFactory(), new CustomRejectionHandler());

        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1,1,1,TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executor.allowCoreThreadTimeOut(true);
        for(int i=1; i<=7 ; i++){
            Future<?> future = executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task executed by : " + Thread.currentThread().getName());
            });

        }
        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(false);
        return t;
    }
}

class CustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected : " + r.toString());
    }
}


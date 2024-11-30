package java8_finalprep;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class PrintEvenOddUsingTwoThreadsUsingCompletableFuture {

    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,
                TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        IntStream.rangeClosed(1,10)
                .forEach(num -> {

                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(i -> {
                                if (i % 2 == 0)
                                    System.out.println(i + " is printed by " + Thread.currentThread().getName());
                                return i;
                            }, executor);
                    evenCompletableFuture.join();

                    CompletableFuture<Integer> oddCompletablefuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(i -> {
                                if (i % 2 != 0)
                                    System.out.println(i + " is printed by " + Thread.currentThread().getName());
                                return i;
                            }, executor);
                    oddCompletablefuture.join();

                });
        executor.shutdown();
    }
}

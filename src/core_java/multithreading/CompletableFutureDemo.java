package core_java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/*
Diff between thenApply and thenCompose = thenApply does not maintain order but thenCompose maintain order.
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<List<Integer>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task execution by : " + Thread.currentThread().getName());
            List<Integer> ans = new ArrayList<>();
            ans.add(10);
            ans.add(40);
            ans.add(5);
            return ans;
        }, executor).thenComposeAsync(l -> {
                    System.out.println("Task execution by : " + Thread.currentThread().getName());
                    return CompletableFuture.supplyAsync(() -> l.stream().sorted().collect(Collectors.toList()));
                }
                , executor);
        System.out.println(listCompletableFuture.get());

        CompletableFuture<String> str1 = CompletableFuture.supplyAsync(() -> "I love ",executor);
        CompletableFuture<String> str2 = CompletableFuture.supplyAsync(() -> "java", executor);

        CompletableFuture<String> stringCombineCompletableFuture = str1.thenCombineAsync(str2, (s1, s2) -> s1 + s2);
        System.out.println(stringCombineCompletableFuture.get());

    }
}
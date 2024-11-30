package java8_finalprep;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintEvenOddUsingTwoThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,10, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2)
        , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<List<Integer>> streamCompletableFuture = CompletableFuture.supplyAsync(() ->
                {
                    List<Integer> numberList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
                    List<Integer> even = numberList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
                    even.forEach(e -> System.out.println(e + " is printed by " + Thread.currentThread().getName()));
                    return numberList;
                }, executor)
                .thenComposeAsync(list -> CompletableFuture.supplyAsync(() -> {
                    List<Integer> even = list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
                    even.forEach(e -> System.out.println(e + " is printed by " + Thread.currentThread().getName()));
                    return list;
                }), executor);
        streamCompletableFuture.get();
        executor.shutdown();
    }
}

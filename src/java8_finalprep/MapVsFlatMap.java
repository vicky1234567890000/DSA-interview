package java8_finalprep;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<String> list = List.of("apple","orange","banana","pineapple");

        List<String> collect = list.stream().flatMap(s -> s.chars().mapToObj(c -> String.valueOf((char) c)))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        List<List<String>> lists = List.of(List.of("aabb","ccaa"), List.of("bbaa","ddaa"));
        List<String> collect1 = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect1);

        List<String> collect2 = lists.stream().flatMap(Collection::stream).flatMap(s -> s.chars().mapToObj(c -> String.valueOf((char) c)))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect2);

        List<String> strings = Stream.of("vfvJF", "hdvhjdv", "bfbf", "jbfkja").flatMap(s -> s.chars().mapToObj(c -> String.valueOf((char) c)))
                .toList();
        System.out.println(strings);

        List<String> strings1 = Stream.of("a", "b", "c", "d").map(String::toUpperCase).collect(Collectors.toList());

        String s = null;
        String defaultMsg = Optional.ofNullable(s).orElse("default msg");
        System.out.println(defaultMsg);

        String str1 = "test@gmail.com";
        String s1 = Optional.ofNullable(str1).map(String::toUpperCase).orElseGet(() -> "default@gmail.com");
        System.out.println(s1);

        String sttr = null;
        String is_null = Optional.ofNullable(sttr).map(String::toUpperCase).orElseThrow(() -> new RuntimeException("str1 is null"));
        System.out.println(is_null);

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);

        int[] arr = {1,10,6,2};
        Integer max = Arrays.stream(arr).boxed().reduce(Integer.MIN_VALUE, (a, b) -> (a > b) ? a : b);
        System.out.println(max);
    }
}

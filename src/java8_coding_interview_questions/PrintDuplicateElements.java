package java8_coding_interview_questions;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintDuplicateElements {
    public static void main(String[] args) {

        String str = "iloveupasana";
        List<String> strings = Stream.of(str.split(""))
                .collect(Collectors.filtering(s -> !s.equals("a"), Collectors.mapping(s -> s.toUpperCase(), Collectors.toList())));
        System.out.println(strings);

        List<String> stringList = Stream.of(str.split(""))
                .map(s -> {
                    if (!s.equals("a")) {
                        return s.toUpperCase();
                    }
                    return s;
                }).collect(Collectors.toList());
        System.out.println(stringList);

        String strg = "abhiseklovesupasana";
        List<String> duplicateStrings = Stream.of(strg.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(duplicateStrings);

    }
}

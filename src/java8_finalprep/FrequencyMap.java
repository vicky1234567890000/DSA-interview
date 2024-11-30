package java8_finalprep;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyMap {
    public static void main(String[] args) {
        String s = "banana";
        Map<String, Long> collect = Stream.of(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        List<String> duplicates = collect.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicates);

        String[] split = s.split("");
        Map<String,Integer> fmap = new HashMap<>();
        for(String str : split) fmap.put(str, fmap.getOrDefault(str, 0)+1);

        System.out.println(fmap);

        LinkedHashMap<String, Integer> linkedHashMap = fmap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,

                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println(linkedHashMap);

    }
}

package java8_finalprep;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NthHighestSalaryUsingGroupBy {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("apple",1000);
        map.put("orange",1000);
        map.put("banana",50);
        map.put("grapes",50);
        map.put("pineapple",2000);
        map.put("jackfruit",2000);

        int n = 3;
        LinkedHashMap<Integer, List<String>> nthHighestPriceFruits = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .skip(n - 1)
                .limit(1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,

                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println(nthHighestPriceFruits);

        List<String> fruits = List.of("apple","orange","banana","pineapple","jackfruit");

        Map<Integer, List<String>> collect = fruits.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(Function.identity(), Collectors.toList())));

        System.out.println(collect);
    }
}

package java8_finalprep;

import java.util.*;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("apple","fruit");
        map.put("potato","vegetable");
        map.put("cow","animal");
        map.put("india","place");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Comparator<Map.Entry<String, String>> comparator = (e1,e2) -> {
            int i = e1.getKey().length() - e2.getKey().length();
            return i==0 ? e1.getKey().compareTo(e2.getKey()) : i;
        };

        LinkedHashMap<String, String> collect = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println(collect);
        List<Integer> l = List.of(1,3,5,2,0);
        l.stream().sorted(Comparator.naturalOrder());

        LinkedHashMap<String, String> collect1 = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println(collect1);
    }
}

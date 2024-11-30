package java8_finalprep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabb";
        Optional<Map.Entry<String, Long>> optionalFirst = Stream.of(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst();
        optionalFirst.ifPresentOrElse(
                e -> System.out.println("first non repeating element is : " + e.getKey()),
                () -> System.out.println("first non repeating element is not present")
        );

    }
}

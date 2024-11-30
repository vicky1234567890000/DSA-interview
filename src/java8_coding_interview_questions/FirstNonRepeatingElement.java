package java8_coding_interview_questions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        String str = "abracadabrac";

        // first non-repeating element
        String firstNonReapting = Stream.of(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList().get(0);

        System.out.println(firstNonReapting);

        //first repeating element
        String str1 = "acbcb";
        String firstReaptingElement = Stream.of(str1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList().get(0);
        System.out.println(firstReaptingElement);

    }
}

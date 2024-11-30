package java8_finalprep;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestStringInList {
    public static void main(String[] args) {
        String[] strArr = {"apple","banana","orange","grapes","pineapple","jackfruit"};
        Stream.of(strArr).sorted((s1,s2) -> s1.length() - s2.length()).collect(Collectors.toList());

        Optional<Integer> highestFrequency = Stream.of(strArr).sorted(Comparator.comparing(String::length).reversed()).map(String::length)
                .distinct().findFirst();

        if(highestFrequency.isPresent()){
            List<String> longestStrings = Stream.of(strArr).filter(s -> s.length() == highestFrequency.get()).collect(Collectors.toList());
            System.out.println("longest Strings are : " + longestStrings);
        } else{
            System.out.println("No longest String in list");
        }
    }
}

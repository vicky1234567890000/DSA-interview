package java8_finalprep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthLongestString {
    public static void main(String[] args) {
        String[] str = {"hibernate","java","developer","spring"};
        Integer max = Arrays.stream(str).map(String::length).distinct().sorted(Comparator.reverseOrder()).findFirst().get();

        List<String> collect = Arrays.stream(str).filter(s -> s.length() == max).collect(Collectors.toList());
        System.out.println(collect);
    }
}

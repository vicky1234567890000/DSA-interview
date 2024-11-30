package java8_coding_interview_questions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterFrequency {
    public static void main(String[] args) {

        String str = "ilovejavatechie";
//        String rev = new StringBuilder(str).reverse().toString();
//        System.out.println(rev);

        String[] strings = str.split("");
        Map<String, Long> map = Stream.of(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);


    }
}

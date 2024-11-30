package basic_java8;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Write a program to print all the unique characters in a String.
//For instance, if the input string is “abcb”, the output will be the characters ‘a’ and ‘c’ as they are unique.
//The character ‘b’ repeats twice and so it will not be printed?
public class Interview {
    public static void main(String[] args) {

        String str = "abcb";
        String[] stringArr = str.split("");

        List<Map.Entry<String, Long>> ans = Stream.of(stringArr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .collect(Collectors.toList());

       for(Map.Entry<String, Long> e : ans){
           System.out.println(e.getKey() + " " + e.getValue());
       }

    }
}

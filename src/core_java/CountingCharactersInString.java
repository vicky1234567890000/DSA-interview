package core_java;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingCharactersInString {
    public static void main(String[] args){

        String str = "banana";
        char[] charArray = str.toCharArray();
        Character[] chArr = new Character[charArray.length];

        for(int i=0;i<charArray.length;i++){
            chArr[i]=charArray[i];
        }

        Map<Character, Long> collect = Stream.of(chArr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }
}

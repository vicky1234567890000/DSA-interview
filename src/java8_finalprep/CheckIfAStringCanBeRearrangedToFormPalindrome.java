package java8_finalprep;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckIfAStringCanBeRearrangedToFormPalindrome {
    public static void main(String[] args) {
        System.out.println(canFormPalindrome("dmaam"));
                
    }

    private static boolean canFormPalindrome(String s) {
        // Count the frequency of each character
        LinkedHashMap<String, Long> fmap = List.of(s.split("")).stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Count the number of characters with odd frequencies
        long oddCount = frequencyMap.values().stream()
                .filter(count -> count % 2 != 0)
                .count();

        // A string can form a palindrome if at most one character has an odd frequency
        return oddCount <= 1;
    }
}

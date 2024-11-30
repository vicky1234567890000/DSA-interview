package two_pointer_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortArrayByFrequency {
    public static void main(String[] args) {
        int[] arr = {5,5,4,6,4};
        ArrayList<Integer> ans = sortByFreq(arr, arr.length);
        System.out.println(ans);
    }

    private static ArrayList<Integer> sortByFreq(int[] arr, int length) {

        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Sort the array according to the frequency map
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
                    return freqCompare != 0 ? freqCompare : a.compareTo(b);
                })
                .toList();
        return new ArrayList<>(list);
    }
}

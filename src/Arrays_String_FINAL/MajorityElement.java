package Arrays_String_FINAL;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/problems/majority-element/submissions/1312653924/
public class MajorityElement {
    public static void main(String[] args) {

        int[] arr = {2,2,1,1,1,2,2};
        int ans = majorityElement(arr);
        System.out.println(ans);
    }

    private static int majorityElement(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > arr.length/2)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }


}

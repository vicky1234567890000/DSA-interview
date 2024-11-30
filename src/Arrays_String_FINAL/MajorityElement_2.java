package Arrays_String_FINAL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement_2 {
    public static void main(String[] args) {


        int[] arr = {1};
        List<Integer> list = majorityElement(arr);
        System.out.println(list);
    }

    public static List<Integer> majorityElement(int[] nums) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length/3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

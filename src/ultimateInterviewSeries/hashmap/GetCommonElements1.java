package ultimateInterviewSeries.hashmap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetCommonElements1 {
    public static void main(String[] args) {
        int[] arr1 = {2,1,3,3,2,1};
        int[] arr2 = {1,3,3};

        Map<Integer, Long> hmap1 = Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(int x : arr2){
            if(hmap1.containsKey(x)) {
                System.out.print(x + " ");
                hmap1.remove(x);
            }
        }
    }
}

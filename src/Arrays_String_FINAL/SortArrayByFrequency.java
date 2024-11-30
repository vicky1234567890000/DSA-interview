package Arrays_String_FINAL;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortArrayByFrequency {
    public static void main(String[] args) {
        int[] arr = {9,9,9,9,5,5,6,6,6,6,6,6,6,4,4,4,4,4,4};




        Map<Integer, Long> fmap =
                Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Arrays.stream(arr)
                        .boxed()
                                .sorted((a,b) -> {

                                   long freqMap = fmap.get(b) - fmap.get(a);
                                   return Math.toIntExact(freqMap == 0L ? a - b : freqMap);

                                }).collect(Collectors.toList());

        Arrays.stream(arr).boxed().sorted((a, b) -> {
            Long freqComp = fmap.get(b) - fmap.get(a);
            freqComp = freqComp == 0L ? a - b : freqComp;
            return Math.toIntExact(freqComp);
        });
        System.out.println(Arrays.toString(arr));
        List<Integer> ans = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                            Long freqComp = fmap.get(b) - fmap.get(a);
                            freqComp = freqComp == 0L ? a - b : freqComp;
                            return Math.toIntExact(freqComp);
                        }
                ).collect(Collectors.toList());
        System.out.println(ans);

    }
}

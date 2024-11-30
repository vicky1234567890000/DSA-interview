package sorting_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1
public class TopKFrequentElementsInArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,4};
        int k = 2;

        int[] ans = topK(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] topK(int[] arr, int k) {

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int x : arr) fmap.put(x, fmap.getOrDefault(x, 0)+1);

        return fmap.entrySet()
                .stream()
                .sorted(
                        (e1, e2) -> {
                            int freqComp = e2.getValue().compareTo(e1.getValue());
                            return freqComp != 0 ? freqComp : e2.getKey().compareTo(e1.getKey());
                        }
                ).map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(e -> e)
                .toArray();

    }
}

package sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

// https://www.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1
public class SortElementsOfAnArrayByFrequency {
    public static void main(String[] args) {
        int[] arr = {5,5,4,6,4};

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            fmap.put(arr[i], fmap.getOrDefault(arr[i],0)+1);
        }

        int[] sortedArray = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int compareFreq = fmap.get(b) - fmap.get(a);
                    return compareFreq != 0 ? compareFreq : Integer.compare(a, b);
                })
                .mapToInt(e -> e)
                .toArray();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x : sortedArray){
            ans.add(x);
        }
        System.out.println(ans);
    }
}

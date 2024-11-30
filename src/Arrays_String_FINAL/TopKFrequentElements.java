package Arrays_String_FINAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1
public class TopKFrequentElements {

    public static void main(String[] args) {
//        int[] arr = {1,1,2,2,3,3,3,4};
//        int k = 2;
//        int[] ans = topKFrequent(arr, k);
//        System.out.println(Arrays.toString(ans));

divide(4,0);

int x = 1;
for(int i=1; i<=128; i += i){
    x += x;
}
        System.out.println(x);
    }

    private static int divide(int a, int b){

        int c = -1;
        try {
            c = a/b;
        }
        catch (Exception e){
            System.out.print("Exception");

        }finally {
            System.out.println("Finally");
        }
        return c;

    }

    private static int[] topKFrequent(int[] arr, int k) {
        Map<Integer,Integer> fmap = new HashMap<>();
        for(int e : arr) fmap.put(e, fmap.getOrDefault(e, 0) + 1);


        return fmap.entrySet().stream()
                .sorted((e1, e2) -> {
                    int freqComp = e2.getValue() -  e1.getValue();
                    return freqComp != 0 ? freqComp : e2.getKey() - e1.getKey();
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(i -> i)
                .toArray();

    }

}

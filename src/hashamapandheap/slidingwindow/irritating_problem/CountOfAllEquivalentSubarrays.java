package hashamapandheap.slidingwindow.irritating_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CountOfAllEquivalentSubarrays {
    public static void main(String[] args) {

        int[] arr = {2, 1, 3, 2, 3};
        HashSet<Integer> set = new HashSet<>();

        Arrays.stream(arr).boxed().forEach(set::add);

        int k = set.size();
        int i = -1;
        int j = -1;


        int ans = 0;
        HashMap<Integer,Integer> fmap = new HashMap<>();

        while(true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < arr.length - 1) {
                f1 = true;
                i++;
                fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
                int count = fmap.size();

                if (count == k) {
                    ans += arr.length - i;
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                int freq = fmap.get(arr[j]);
                if (freq == 1) {
                    fmap.remove(arr[j]);
                } else {
                    fmap.put(arr[j], fmap.get(arr[j]) - 1);
                }
                int count = fmap.size();
                if (count == k) {
                    ans += arr.length - i;
                } else {
                    break;
                }
            }
            if(!f1 && !f2) break;
        }
        System.out.println(ans);
    }
}

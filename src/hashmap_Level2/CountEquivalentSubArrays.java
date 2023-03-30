package hashmap_Level2;

import java.util.HashMap;
import java.util.HashSet;

public class CountEquivalentSubArrays {

    public static void main(String[] args){

        int[] arr = {2,5,3,5,2,4,1,3,1,4};
        HashMap<Integer,Integer> fmap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int value : arr){
            set.add(value);
        }
        int k = set.size();

        int count = 0;
        int i = -1;
        int j = -1;

        while(true) {

            boolean f1 = false;
            boolean f2 = false;
            while (i < arr.length - 1) {
                f1 = true;
                i++;

                fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
                if (fmap.size() == k) {
                    count += arr.length - i;
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                if (fmap.get(arr[j]) == 1) {
                    fmap.remove(arr[j]);
                } else {
                    fmap.put(arr[j], fmap.get(arr[j]) - 1);
                }

                if (fmap.size() == k) {
                    count += arr.length - i;
                } else {
                    break;
                }

            }
            if(!f1 && !f2) break;
        }
        System.out.println(count);
    }

}

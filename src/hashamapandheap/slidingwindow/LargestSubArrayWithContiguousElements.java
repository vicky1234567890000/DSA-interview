package hashamapandheap.slidingwindow;

import java.util.HashSet;

public class LargestSubArrayWithContiguousElements {

    public static void main(String[] args) {
        int[] arr = {9,7,8,4,6,2,1,3};

        int maxLen=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length-1; i++){

            int max = arr[i];
            int min = arr[i];
            set.add(arr[i]);
            for(int j=i+1; j<arr.length; j++){
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);

                if(max - min == j - i){
                    int len = j - i + 1;
                    if(len > maxLen){
                        maxLen = len;
                    }
                }

            }
        }

        System.out.println(maxLen);
    }
}

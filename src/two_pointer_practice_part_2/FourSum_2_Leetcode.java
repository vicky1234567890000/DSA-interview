package two_pointer_practice_part_2;

import java.util.HashMap;

// https://leetcode.com/problems/4sum-ii/description/
public class FourSum_2_Leetcode {
    public static void main(String[] args) {

        int[] arr1 = {1,2};
        int[] arr2 = {-2,-1};
        int[] arr3 = {-1,2};
        int[] arr4 = {0,2};

        int ans = fourSumCount(arr1, arr2, arr3, arr4);
        System.out.println(ans);

    }

    private static int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e1 : arr1){
            for(int e2 : arr2){
                int sum = e1 + e2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for(int e3 : arr3){
            for(int e4 : arr4){
                int sum = e3 + e4;
                count += map.getOrDefault(-sum, 0);
            }
        }


        return count;
    }
}

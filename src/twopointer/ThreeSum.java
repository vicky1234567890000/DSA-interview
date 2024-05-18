package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        int target = 0;
        List<List<Integer>> ans = threeSum(arr, target);
        System.out.println(ans);
    }

    private static List<List<Integer>> threeSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<arr.length-2; i++){

            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            int l = i+1;
            int r = arr.length-1;

            while(l < r){
                int sum = arr[i] + arr[l] + arr[r];
                if(sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[l]);
                    list.add(arr[r]);
                    res.add(list);
                    l++;
                    r--;

                    while(l<r && arr[l] == arr[l-1]){
                        l++;
                    }
                    while(l < r && arr[r] == arr[r+1]){
                        r--;
                    }
                }
                else if(sum < target) {
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return res;

    }
}

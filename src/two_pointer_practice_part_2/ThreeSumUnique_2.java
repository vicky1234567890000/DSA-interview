package two_pointer_practice_part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
// Input:
//        N = 4
//        arr[] = {1, 5, 3, 2}
//        Output: 2
//        Explanation: There are 2 triplets:
//        1 + 2 = 3 and 3 +2 = 5
public class ThreeSumUnique_2 {
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 2};

        List<List<Integer>> ans = threeSum(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> threeSum(int[] arr){

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=arr.length -1; i >= 2; i--){

            int l = 0;
            int r = i-1;

            while(l < r){
                int sum = arr[l] + arr[r];
                if(sum == arr[i]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[l]);
                    list.add(arr[r]);
                    ans.add(list);
                    l++;
                    r--;
                }

                else if (sum < arr[i]) l++;
                else r--;

            }

        }
        return ans;
    }

}

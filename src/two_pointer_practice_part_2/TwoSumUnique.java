package two_pointer_practice_part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumUnique {
    public static void main(String[] args) {
        int[] arr = {-2,12,2,-1,11,-2,12};
        int tar = 10;
        List<List<Integer>> ans = twoSum(arr, tar);
        System.out.println(ans);
    }

    private static List<List<Integer>> twoSum(int[] arr, int tar){

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int l = 0;
        int r = arr.length -1;

        while(l < r){
            int sum = arr[l] + arr[r];

            if(sum == tar){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[l]);
                list.add(arr[r]);
                ans.add(list);
                l++;
                r--;

                while(l < r && arr[l] == arr[l-1]) l++;
                while(l < r && arr[r] == arr[r+1]) r--;
            }
            else if(sum < tar) l++;
            else r--;

        }
        return ans;
    }

}

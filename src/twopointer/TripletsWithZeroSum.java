package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TripletsWithZeroSum {
    public static void main(String[] args){
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = threeSum(arr);

        for(List<Integer> l : res){
            System.out.println(l);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3) return res;

        Arrays.sort(nums);
        int i=nums.length-1;

        while(i>1){

            if(i != nums.length-1 && nums[i]==nums[i+1]){
                i--;
                continue;
            }
            int l=0;
            int r=i-1;

            while(l<r){
                if( l != 0 && nums[l]==nums[l-1]){
                    l++;
                    continue;
                }
//                if( r != (i-1) && nums[r]==nums[r+1]){
//                    r--;
//                    continue;
//                }
                if(nums[l]+nums[r] == -nums[i]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    temp.add(nums[i]);
                    res.add(temp);
                    l++;
                    r--;
                }else if(nums[l] + nums[r] < -nums[i]){
                    l++;
                }else{
                    r--;
                }
            }
            i--;
        }

        return res;

    }
}

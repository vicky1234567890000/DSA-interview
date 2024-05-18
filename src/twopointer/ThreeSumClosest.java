
package twopointer;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/3-sum-closest/1
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int target = 1;
        int ans = threeSumClosest(nums, target);
        System.out.println(ans);

    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length-1];
        for(int i=0; i<nums.length-2; i++){

            if(i !=0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                int currSum = nums[i] + nums[l] + nums[r];
                if(currSum > target){
                    r--;
                } else {
                    l++;
                }

                if(Math.abs(currSum - target) < Math.abs(closestSum - target)){
                    closestSum = currSum;
                }
            }
        }
        return closestSum;
    }

}

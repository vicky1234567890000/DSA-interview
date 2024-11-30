package TwoPointer_SlidingWndow;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args){
      int[] nums = {4,2,3,4};
        int ans = triangleNumber(nums);
        System.out.println(ans);
    }

    private static int triangleNumber(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if (nums[i] + nums[j] > nums[k]){
                        ans++;
                    }
                }
            }
        }


        return ans;
    }
}

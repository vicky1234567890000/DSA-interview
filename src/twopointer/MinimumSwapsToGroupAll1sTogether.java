package twopointer;

import java.util.Arrays;

public class MinimumSwapsToGroupAll1sTogether {
    public static void main(String[] args){

        int[] nums = {1,0,1,0,1};
        int ans = minSwaps(nums);
        System.out.println(ans);
    }

    private static int minSwaps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int k = 0;
        for(int x : nums){
            if(x==1){
                k++;
            }
        }
        int[] newArr = new int[2*n];
        for(int i=0;i<nums.length;i++){
            newArr[i]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            newArr[i+nums.length]=nums[i];
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<=(2*n-k);i++){
            int zerCount=0;
            int j = i;
            while(j<(i+k)){
                if(newArr[j]==0){
                    zerCount++;
                }
                j++;
            }
            min = Math.min(zerCount,min);
        }

        //System.out.println(Arrays.toString(newArr));



        return min;
    }
}

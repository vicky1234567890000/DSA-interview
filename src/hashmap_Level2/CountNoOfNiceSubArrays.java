package hashmap_Level2;

import java.util.HashMap;

class CountNoOfNiceSubArrays {

    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(arr, 3));
    }

    public static int numberOfSubarrays(int[] nums, int k) {

        int tempans = 0;
        int ans = 0;
        int count = 0;
        int j = 0;


        for (int num : nums) {


            if (num % 2 == 1) {
                count++;
                tempans = 0;
            }


            while (count == k) {
                tempans++;
                int ele = nums[j];
                if (ele % 2 == 1) {
                    count--;
                }
                j++;
            }

            ans += tempans;

        }

        return ans;
    }
}

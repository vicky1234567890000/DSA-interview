package Arrays_String_FINAL;

import java.util.Arrays;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        int pivot = pivotIndex(arr);
        System.out.println(pivot);
    }

    private static int pivotIndex(int[] nums) {
        int rsum = Arrays.stream(nums)
                .boxed()
                .mapToInt(i -> i)
                .sum();

        int lsum = 0;
        for(int i=0; i<nums.length; i++){
            rsum -= nums[i];

            if(lsum == rsum) return i;

            lsum += nums[i];
        }
        return -1;
    }
}

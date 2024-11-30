package two_pointer_practice;

// https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
public class MaximumSumSubArray_Kadane {
    public static void main(String[] args) {

        int[] arr = {1, 2, -3, 4, 5, 7, -100, 50};
        long maxSum = maxSumSubArray(arr);
        System.out.println(maxSum);
    }

    private static long maxSumSubArray(int[] arr) {

        long maxSum = Long.MIN_VALUE;
        long currSum =0;
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];

            maxSum = Math.max(currSum, maxSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}

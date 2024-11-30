package two_pointer_practice_part_2;

// https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
public class MaximumSumCircularSubArray {
    public static void main(String[] args) {
        int[] arr = {8,-8,9,-9,10,-11,12};

        int maxSum = maxSumCircularSubArray(arr);
        System.out.println(maxSum);
    }

    private static int maxSumCircularSubArray(int[] arr) {
        // sum
        // minSum
        // maxSum
        // circularSum = sum - minSum
        // if(maxSum > 0) return max(circularSum, maxSum)
        // else return maxSum

        int sum = 0;
        for(int e : arr) sum += e;

        // maxSum
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int j : arr) {
            currSum += j;

            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // minSum
        int minSum = Integer.MAX_VALUE;
        int currSum2 = 0;

        for (int j : arr) {
            currSum2 += j;

            minSum = Math.min(currSum2, minSum);
            if (currSum2 > 0) {
                currSum2 = 0;
            }
        }

        int maxCircularSum = sum - minSum;
        if(maxSum > 0)
            return Math.max(maxCircularSum, maxSum);
        return maxSum;

    }
}

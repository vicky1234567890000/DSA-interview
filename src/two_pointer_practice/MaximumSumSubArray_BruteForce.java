package two_pointer_practice;

public class MaximumSumSubArray_BruteForce {
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};

        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-1; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);

            }
        }

        System.out.println(maxSum);
    }
}

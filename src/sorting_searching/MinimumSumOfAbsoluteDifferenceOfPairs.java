package sorting_searching;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/minimum-sum-of-absolute-differences-of-pairs/1
public class MinimumSumOfAbsoluteDifferenceOfPairs {
    public static void main(String[] args) {
        int[] A = {4,1,8,7};
        int[] B = {2,3,6,5};

        long min = findMinimum(A, B, A.length);
        System.out.println(min);
    }

    private static long findMinimum(int[] A, int[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += Math.abs(A[i] - B[i]);
        }
        return sum;
    }
}

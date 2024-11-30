package two_pointer_practice;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/maximum-sub-array5443/1
// Find out the maximum sub-array of non negative numbers from an array.
public class MaximumSubArray_GFG {
    public static void main(String[] args) {
        int[] arr = {1,2,5,-7,2,3};
        ArrayList<Integer> ans = findSubarray(arr, arr.length);
        System.out.println(ans);
    }

    private static ArrayList<Integer> findSubarray(int[] arr, int n) {

        int i=0;
        int j=0;

        int start = -1;
        int end = -1;

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int maxLen = 0;

        for(; i<arr.length; i++){

            currSum += arr[i];

            if(arr[i] >= 0){

                if(currSum > maxSum){
                    maxSum = currSum;
                    maxLen = i-j+1;
                    start = j;
                    end = i;
                } else if(currSum == maxSum){
                    if(i-j+1 > maxLen){
                        start = j;
                        end = i;
                    }
                }
            }
            else{
                j = i;
                j++;
                currSum = 0;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int x = start; x<=end; x++){
            ans.add(arr[x]);
        }
        return ans;
    }
}

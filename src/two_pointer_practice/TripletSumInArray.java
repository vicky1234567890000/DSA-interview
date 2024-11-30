package two_pointer_practice;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
public class TripletSumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        boolean ans = find3Numbers(arr,arr.length, 13);
        System.out.println(ans);
    }


    //Function to find if there exists a triplet in the
    //array arr[] which sums up to X.
    private static boolean find3Numbers(int[] arr, int n, int X) {

        Arrays.sort(arr);
        boolean isPresent = false;
        for(int i=0; i<arr.length; i++) {

            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            int l = i+1;
            int r = n-1;

            while(l < r){
                int sum = arr[i] + arr[l] + arr[r];
                if(sum == X){
                    isPresent = true;
                    break;
                } else if(sum < X){
                    l++;
                } else{
                    r--;
                }
            }
            if(isPresent) break;
        }
        return isPresent;
    }
}

package twopointer;

import java.util.Arrays;

// Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
// Input:
//        N = 4
//        arr[] = {1, 5, 3, 2}
//        Output: 2
//        Explanation: There are 2 triplets:
//        1 + 2 = 3 and 3 +2 = 5

public class CountTriplets {

    public static void main(String[] args){
        int[] arr = {1,5,3,2,3,2,5};


        int count = countTriplets(arr,arr.length);
        System.out.println(count);
    }

    private static int countTriplets(int[] arr, int n) {
        int count=0;
        if(arr.length < 3) return count;
        Arrays.sort(arr);
        int i = n-1;
        while(i>1){
            if(i!= (n-1) && arr[i]==arr[i+1]){
                i--;
                continue;
            }
            int l=0;
            int r=i-1;
            while(l<r) {
                if(l != 0 && arr[l]==arr[l-1]){
                    l++;
                    continue;
                }
                if(r != (i-1) && arr[r]==arr[r+1]){
                    r--;
                    continue;
                }
                if (arr[l] + arr[r] == arr[i]) {
                    System.out.println(arr[l]+" "+arr[r]+" "+arr[i]);
                    count++;
                    l++;
                    r--;
                } else if (arr[l] + arr[r] < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
                i--;
            }


        return count;
    }
}

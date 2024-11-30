package two_pointer_practice;

import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/three-sum-closest/1
public class ThreeSumClosest {
    public static void main(String[] args) {

        int[] arr = {-1,2,1,-4};
        int tar = 1;
        int ans = closestThreeSum(arr,tar);
        System.out.println(ans);
    }

    private static int closestThreeSum(int[] arr, int tar) {

        Arrays.sort(arr);
        int closestSum = arr[0] + arr[1] + arr[arr.length - 1];

        for(int i=0; i<arr.length - 2; i++){

            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            int l = i+1;
            int r = arr.length - 1;

            while(l < r){
                int currSum = arr[i] + arr[l] + arr[r];

                if(currSum < tar) {
                    l++;
                } else{
                    r--;
                }

                if(Math.abs(currSum - tar) < Math.abs(closestSum - tar) ||
                        (Math.abs(currSum - tar) == Math.abs(closestSum - tar) && currSum > closestSum)){
                    closestSum = currSum;
                }
            }
        }
        return closestSum;
    }
}

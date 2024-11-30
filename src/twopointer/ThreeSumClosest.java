package twopointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args){
        int[] arr = {-1,2,1,-4};
        int target = 1;

        Arrays.sort(arr);
        int closestSum = arr[0] + arr[1] + arr[arr.length-1];

        for(int i=0;i<arr.length-2;i++){
            int start = i+1;
            int end = arr.length-1;

            while (start < end) {

                int currSum = arr[start]+arr[end]+arr[i];
                if(currSum < target){
                    start++;
                }else if(currSum > target){
                    end--;
                }

                if(Math.abs(currSum-target) < Math.abs(closestSum-target)){
                    closestSum = currSum;
                }
            }
        }

        System.out.println(closestSum);

    }
}

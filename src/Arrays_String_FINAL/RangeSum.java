package Arrays_String_FINAL;

import java.util.Arrays;

// https://www.youtube.com/watch?v=fBT0VKkqvtY&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=2
public class RangeSum {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0};

        int[][] range = {{2,4,3},{1,2,-1},{0,5,2},{4,6,3}};

        int[] ans = rangeSum(arr,range);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] rangeSum(int[] arr, int[][] range) {


            for (int[] array : range) {


                int start = array[0];
                int end = array[1] + 1;

                arr[start] += array[2];
                if(end < arr.length){
                    arr[end] -= array[2];
                }

            }

            // calculate prefix sum
           int sum = 0;
           for(int i=0; i<arr.length; i++){
               sum += arr[i];
               arr[i] = sum;
           }


           return arr;


    }
}

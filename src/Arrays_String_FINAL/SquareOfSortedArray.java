package Arrays_String_FINAL;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1312597561/
public class SquareOfSortedArray {

    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};

        int[] ans = squareArray(arr);
        System.out.println(Arrays.toString(ans));


    }

    private static int[] squareArray(int[] arr) {

        int[] ans = new int[arr.length];
        int i=0;
        int j=arr.length - 1;

        int index = arr.length - 1;

        while(i <= j){

            int val1 = arr[i] * arr[i];
            int val2 = arr[j] * arr[j];

            if(val1 > val2){
                ans[index] = val1;
                i++;
            } else{
                ans[index] = val2;
                j--;
            }
            index--;

        }
        return ans;
    }
}

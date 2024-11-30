package two_pointer_practice;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1,1,0,1,0,0,0,1};
        int[] ans = sort01(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] sort01(int[] arr){
        int i=0;
        int j=0;

        while(i < arr.length){
            if(arr[i] > 0){
                i++;
            } else{
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}

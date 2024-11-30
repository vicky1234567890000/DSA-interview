package two_pointer_practice;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {2,2,0,0,0,2,1,0,1};

        int[] ans = sort012(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] sort012(int[] arr) {

        int i=0; int j=0; int k = arr.length - 1;

        while(i <= k){
            if(arr[i] == 0){
                swap(arr,i,j);
                i++;
                j++;
            } else if(arr[i] == 1){
                i++;
            } else{
                swap(arr, i , k);
                k--;
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

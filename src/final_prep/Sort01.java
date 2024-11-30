package final_prep;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,0};

        int[] ans = sort12(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] sort12(int[] arr) {

        int i=0;
        int j=0;

        while(i < arr.length){
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else{
                i++;
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

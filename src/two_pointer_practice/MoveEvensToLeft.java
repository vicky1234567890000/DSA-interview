package two_pointer_practice;

import java.util.Arrays;

public class MoveEvensToLeft {
    public static void main(String[] args) {
        int[] arr = {0,2,3,5,10,-2,6,13,5,1};
        int[] ans = moveEvens(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] moveEvens(int[] arr) {
        int i=0; int j=0;

        while(i < arr.length){
            if(arr[i] % 2 != 0){
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

package two_pointer_practice;

import java.util.Arrays;



public class PartitionOfArray {
    public static void main(String[] args) {
        int[] arr = {7,9,4,8,3,6,2,1};
        int pivot = 5;
        System.out.println(Arrays.toString(partitionOfArray(arr, pivot)));
    }

    private static int[] partitionOfArray(int[] arr, int p) {
        int i=0;
        int j=0;

        while(i < arr.length){

            if(arr[i] > p) i++;
            else{
                swap(arr,i,j);
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

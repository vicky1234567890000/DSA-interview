package sorting_searching;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,5,1,3,2,10,5};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
    }

    private static int[] mergeSort(int[] arr, int l, int r){
        if(l == r){
            int[] ba = new int[1];
            ba[0] = arr[l];
            return ba;
        }

        int mid = (l+r)/2;
        int[] sortedFirstHalf = mergeSort(arr, l, mid);
        int[] sortedSecondHalf = mergeSort(arr, mid+1, r);

        return mergeTwoSortedArray(sortedFirstHalf, sortedSecondHalf);
    }

    static int[] mergeTwoSortedArray(int[] A, int[] B){

        int i=0;
        int j=0;
        int k=0;

        int[] C = new int[A.length + B.length];
        while(i < A.length && j < B.length){

            if(A[i] <= B[j]){
                C[k++] = A[i++];
            } else{
                C[k++] = B[j++];
            }
        }

        while(i < A.length){
            C[k++] = A[i++];
        }

        while(j < B.length){
            C[k++] = B[j++];
        }

        return C;

    }
}

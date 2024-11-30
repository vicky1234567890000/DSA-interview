package Arrays_String_FINAL;

import java.util.Arrays;

// https://leetcode.com/problems/sort-array-by-parity-ii/
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        int[] ans = sortArrayByParity(arr);


        System.out.println(Arrays.toString(ans));
    }

    private static int[] sortArrayByParity(int[] arr) {

        int oddNoAtEvenIndex=0;
        int evenNoAtOddIndex=1;

        int n = arr.length;

        while(oddNoAtEvenIndex < n && evenNoAtOddIndex < n){

            while(oddNoAtEvenIndex < n && arr[oddNoAtEvenIndex] % 2==0){
                oddNoAtEvenIndex += 2;
            }


            while(evenNoAtOddIndex<n &&    arr[evenNoAtOddIndex] % 2 != 0){
                evenNoAtOddIndex += 2;
            }

            if(oddNoAtEvenIndex < n && evenNoAtOddIndex < n){
                swap(arr, oddNoAtEvenIndex, evenNoAtOddIndex);
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

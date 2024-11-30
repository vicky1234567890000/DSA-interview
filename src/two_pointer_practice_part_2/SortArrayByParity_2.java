package two_pointer_practice_part_2;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/even-and-odd/0
public class SortArrayByParity_2 {
    public static void main(String[] args) {




        int[] arr = {15,10,2,4,6,8,5,55,25,35};
        int oddNoAtEvenIndex = 0;
        int evenNoAtOddIndex = 1;

        int n = arr.length;
        while(oddNoAtEvenIndex < n && evenNoAtOddIndex < n){

            while(oddNoAtEvenIndex < n && arr[oddNoAtEvenIndex] % 2 == 0){
                oddNoAtEvenIndex +=2;
            }

            while(evenNoAtOddIndex < n && arr[evenNoAtOddIndex] % 2 == 1){
                evenNoAtOddIndex += 2;
            }

            if(oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {
                swap(arr, oddNoAtEvenIndex, evenNoAtOddIndex);
            }
        }

        System.out.println(Arrays.toString(arr));


    }

    private static void swap(int[] arr, int i, int j){
        if(i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}

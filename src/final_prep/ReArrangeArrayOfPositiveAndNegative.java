package final_prep;

import java.util.Arrays;

public class ReArrangeArrayOfPositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 4, -3, -16, 6};

        int[] ans = rearrange(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] rearrange(int[] arr) {

        int negNoAtEvenIndex = 0;
        int posNumberAtOddIndex = 1;

        int n = arr.length;

        while(negNoAtEvenIndex < n && posNumberAtOddIndex < n){

            while(negNoAtEvenIndex < n && arr[negNoAtEvenIndex] > 0){
                negNoAtEvenIndex += 2;
            }

            while(posNumberAtOddIndex < n && arr[posNumberAtOddIndex] < 0){
                posNumberAtOddIndex += 2;
            }

            if(negNoAtEvenIndex < n && posNumberAtOddIndex < n){
                swap(arr, negNoAtEvenIndex, posNumberAtOddIndex);
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

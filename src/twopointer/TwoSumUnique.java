package twopointer;

import java.util.Arrays;

public class TwoSumUnique {
    public static void main(String[] args){

        int[] arr = {1,2,0,-1,5,-4,1,5};
        Arrays.sort(arr);
        int target = 1;
        int count = 0;

        int i=0;
        int j=arr.length-1;

        while(i<j){

            if(i != 0 && arr[i]==arr[i-1]){
                i++;
                continue;
            }

            if(arr[i] + arr[j] == target){
                System.out.println(arr[i] +","+ arr[j]);
                count++;
                i++;
                j--;
            }else if(arr[i] + arr[j] < target){
                i++;
            }else{
                j--;
            }
        }

        System.out.println(count);
    }
}

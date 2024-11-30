package twopointer;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumNoOfSwapsToSort {

    public static void main(String[] args){
        int[] arr = {4,2,3};
        int ans = countSwaps(arr);
        System.out.println(ans);
    }

    public static int countSwaps(int[] arr) {

        int count = 0;
        int[] copyArr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copyArr);

        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<copyArr.length;i++){
            indexMap.put(copyArr[i],i);
        }

        for(int i=0;i<arr.length;i++){

            while(indexMap.get(arr[i]) != i){
                count++;
                swap(arr,indexMap.get(arr[i]),i);
            }
        }
        return count;
    }

    private static void swap(int[] arr,int a, int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

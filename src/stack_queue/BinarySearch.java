package stack_queue;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args){

        int[] arr = {2,3,5,7};
        int index = Arrays.binarySearch(arr, 2);

        System.out.println(index);
    }
}

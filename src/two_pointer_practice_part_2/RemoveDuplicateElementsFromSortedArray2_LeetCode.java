package two_pointer_practice_part_2;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicateElementsFromSortedArray2_LeetCode {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

        int i=0;
//        for(int e : arr){
//            if(i==0 || i==1 || e != arr[i-2]){
//                arr[i] = e;
//                i++;
//            }
//        }

        for(int e : arr){
            if(i==0  || e != arr[i-1]){
                arr[i] = e;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(i);
    }
}

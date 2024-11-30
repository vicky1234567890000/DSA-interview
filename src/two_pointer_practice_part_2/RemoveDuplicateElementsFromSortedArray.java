package two_pointer_practice_part_2;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1?page=1&company%5B%5D=Wipro&sortBy=submissions
public class RemoveDuplicateElementsFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        int index = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[index]){
                arr[index + 1] = arr[i];
                index++;
            }
        }
        System.out.println(index + 1);
        int N = index + 1;
        int[] ans = new int[N];
        for(int i=0; i<N; i++){
            ans[i] = arr[i];
        }
        System.out.println(Arrays.toString(ans));

//        int index = 0;
//        for(int i=1; i < arr.length; i++){
//            if(arr[i] != arr[i-1]){
//                arr[index+1] = arr[i];
//                index++;
//            }
//        }
//        return index + 1;
    }
}

package two_pointer_practice_part_2;

import java.util.Arrays;

public class RDEFSA_practice {
    public static void main(String[] args) {
        int[] arr = {5,5,5,5,5,5,10,10,15,20,20,20};
        int[] nums = {5,5,5,5,5,5,10,10,15,20,20,20};

        int i=0;
        for(int e : arr){
            if(i==0 || i==1 || e != arr[i-2]){
                arr[i] = e;
                i++;
            }
        }
        for(int x=0; x<i; x++){
            System.out.print(arr[x] + " ");
        }
        System.out.println();
        removeDuplicates(nums);
    }

    private static void removeDuplicates(int[] nums) {

        int i = 0;
        for(int e : nums){

            if(i == 0 || e != nums[i-1]){
                nums[i] = e;
                i++;
            }
        }
        for(int x=0; x<i; x++){
            System.out.print(nums[x] + " ");
        }

    }
}

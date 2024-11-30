package two_pointer_practice;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class ValidTriangleNumber {
    public static void main(String[] args) {

        int[] arr = {6, 4, 9, 7, 8};
        Arrays.sort(arr);

        int count = 0;

        for(int i=2; i<arr.length; i++){
            int l = 0;
            int r = i-1;

            while(l < r) {
                int sum = arr[l] + arr[r];
                if(sum > arr[i]) {
                    count += (r - l);
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        System.out.println(count);
    }
}

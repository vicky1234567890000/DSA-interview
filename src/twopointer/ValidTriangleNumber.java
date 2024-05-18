package twopointer;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] arr = {2,6,7,8,16,21};
        int count = countValidTriangles(arr);
        System.out.println(count);
    }

    private static int countValidTriangles(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for(int i=2; i<arr.length; i++){
            int l = 0; int r = i-1;
            while(l < r){
                if(arr[l] + arr[r] > arr[i]){
                    count += (r - l);
                    r--;
                }else{
                    l++;
                }
            }
        }
        return count;
    }
}

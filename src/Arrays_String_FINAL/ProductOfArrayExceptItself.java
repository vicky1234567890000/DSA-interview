package Arrays_String_FINAL;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};

        long[] res = productOfArrayExceptItself(arr);
        System.out.println(Arrays.toString(res));
    }

    private static long[] productOfArrayExceptItself(int[] arr) {

        int n = arr.length;

        long[] lp = new long[n];
        long[] rp = new long[n];
        long[] ans = new long[n];

        lp[0] = 1;
        rp[n-1] = 1;


        for(int i=1; i<n; i++){

            lp[i] = lp[i-1] * arr[i-1];
        }

        for(int i=n-2; i>=0; i--){
            rp[i] = rp[i+1] * arr[i+1];
        }

        for(int i=0; i<n; i++){
            ans[i] = lp[i] * rp[i];
        }

        return ans;
    }
}

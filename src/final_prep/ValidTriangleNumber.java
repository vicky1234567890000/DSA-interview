package final_prep;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {

        int[] arr = {2,2,3,4};
        Arrays.sort(arr);

       int ans = 0;
        for(int i=2; i<arr.length; i++){
            int l = 0;
            int r = i-1;

            while(l < r){

                int sum = arr[l] + arr[r];
                if(sum > arr[i]){
                    ans += (r - l);
                    r--;
                } else{
                    l++;
                }
            }
        }

        System.out.println(ans);

    }
}

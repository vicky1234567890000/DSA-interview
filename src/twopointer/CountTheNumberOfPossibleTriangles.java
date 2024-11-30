package twopointer;

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles {
    public static void main(String[] args){

        int[] arr = {6, 4, 9, 7, 8};
        int ans = findNumberOfTriangles(arr);

        System.out.println(ans);
    }

    private static int findNumberOfTriangles(int[] arr) {

        Arrays.sort(arr);
        int count = 0;
        if(arr.length<3) return count;
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i] + arr[j] > arr[k] && arr[i] + arr[k] > arr[j] &&
                            arr[j] + arr[k] > arr[i]){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
/*
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        Arrays.sort(arr);
        int count = 0;
        if(arr.length < 3) return count;
        int i=arr.length-1;

        while(i > 1){
            int l=0;
            int r=i-1;
            while(l<r){
                if(arr[l] + arr[r] > arr[i]){
                    count += (r-l);
                    r--;
                }else if(arr[l] + arr[r] <= arr[i]){

                    l++;
                }
            }
            i--;
        }

        return count;

    }

 */

package two_pointer_practice;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
public class FourSum {
    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,7,8};
        int X = 23;
        ArrayList<ArrayList<Integer>> ans = fourSum(arr, X);
        System.out.println(ans);
    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int X) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0; i<arr.length - 3; i++){

            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            for(int j=i+1; j < arr.length - 2; j++){

                if(j != i+1 && arr[j] == arr[j-1]){
                    continue;
                }

                int l = j+1;
                int r = arr.length - 1;

                while(l < r){
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if(sum == X){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[l]);
                        list.add(arr[r]);
                        ans.add(list);

                        l++;
                        r--;

                        while(l < r && arr[l] == arr[l-1]) l++;
                        while(l < r && arr[r] == arr[r+1]) r--;

                    } else if(sum < X){
                        l++;
                    } else{
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}

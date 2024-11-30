package two_pointer_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KDiffArrayPairs {

    public static void main(String[] args) {

        int[] arr = {2,4,0};
        int K = 2;

        List<List<Integer>> ans = kDiffArrayPairs(arr, K);
        System.out.println(ans);

    }

    private static List<List<Integer>> kDiffArrayPairs(int[] arr, int K) {

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int i=0;
        int j=1;

        while(i < arr.length && j < arr.length){

            int diff = Math.abs(arr[j] - arr[i]);
            if(diff == K){
                List<Integer> list = new ArrayList<>();
                list.add(arr[j]);
                list.add(arr[i]);
                ans.add(list);
                i++;
                j++;

                while(j < arr.length && arr[j] == arr[j-1]) j++;
            }
            else if(diff < K){
                j++;
            }

            else{
                i++;
                if(i == j){
                    j++;
                }
            }

        }
        return ans;
    }
}

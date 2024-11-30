package greedy;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

    public static void main(String[] args){

        int[] arr = {1,2,3,7,5};
        ArrayList<Integer> res = subarraySum(arr,arr.length,12);
        System.out.println(res);
    }

    private static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        for(int i=0;i<n-1;i++){

            int curr_sum = arr[i];
            if(curr_sum == s){
                ArrayList<Integer> res = new ArrayList<>();
                res.add(s);
                return res;
            }

            for(int j=i+1;j<n;j++){

                curr_sum += arr[j];
                if(curr_sum == s){
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(i+1);
                    res.add(j+1);
                    return res;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        return res;

    }
}

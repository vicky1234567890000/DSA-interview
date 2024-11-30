package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithKSum {
    public static void main(String[] args){

        int[] arr = {-1,-4,-1,0,2,1,3};
        int target = 5;

        List<List<Integer>> res = threeSum(arr,target);
        for(List<Integer> l : res){
            System.out.println(l);
        }
    }

    private static List<List<Integer>> threeSum(int[] arr, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            if(i != 0 && arr[i]==arr[i-1]){
                continue;
            }

            int val = arr[i];
            int targ = target - val;

            List<List<Integer>> subRes = twoSum(arr,i,arr.length-1,targ);
            if(subRes.size() != 0) {
                for (List<Integer> l : subRes) {
                    l.add(val);
                    res.add(l);
                }
            }
        }

        return res;

    }

    private static List<List<Integer>> twoSum(int[] arr, int si, int ei, int target) {

        List<List<Integer>> res = new ArrayList<>();
        int i=si;
        int j=ei;

        while(i<j){


            if(i != si && arr[i]==arr[i-1]){
                i++;
                continue;
            }

            int sum = arr[i] + arr[j];
            if(sum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[j]);
                res.add(temp);
                i++;
                j--;
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }

        return res;
    }
}

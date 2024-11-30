package two_pointer_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortArrayByFrequency_1 {

    public static void main(String[] args) {
        int[] arr = {5,5,4,6,4};
        ArrayList<Integer> ans = sortByFreq(arr, arr.length);
        System.out.println(ans);
    }

    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr)map.put(i,map.getOrDefault(i,0)+1);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a, b)-> {
            if(map.get(b) == map.get(a))return a-b;
            else return map.get(b)-map.get(a);
        });
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x : list){
            while(map.get(x) != 0){
                ans.add(x);
                map.put(x, map.getOrDefault(x,0)-1);
            }
        }

        return ans;

    }
}

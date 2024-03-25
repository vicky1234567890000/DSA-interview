package hashamapandheap.slidingwindow.irritating_problem;

import java.util.HashMap;

// https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
public class CountOfAllZerSumSubArrays {
    public static void main(String[] args) {


        int[] arr = {15,-2,2,-8,1,7,10,23};
        int count = 0;

        HashMap<Integer,Integer> sumFreqMap = new HashMap<>();
        int sum = 0;
        sumFreqMap.put(sum,1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(!sumFreqMap.containsKey(sum)){
                sumFreqMap.put(sum,1);
            }else{
                int freq = sumFreqMap.get(sum);
                count += freq;
                sumFreqMap.put(sum, freq+1);
            }
        }
        System.out.println(count);
    }
}

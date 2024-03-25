package hashamapandheap.slidingwindow.irritating_problem;

import java.util.HashMap;

// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class LargestZeroSumSubarray {
    public static void main(String[] args) {


       // int[] arr = {1,0,0,1,-2,0,3,2,-1,3,-3,-4}; (array should not contain zeros)
        int[] arr = {15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> sumIdx = new HashMap<>();


        int sum = 0;
        sumIdx.put(0,-1);
        int maxLen = 0;
        for(int i=0; i<arr.length; i++){


            sum += arr[i];
            if(!sumIdx.containsKey(sum))
            {
                sumIdx.put(sum,i);
            }else{
                int prevIdx = sumIdx.get(sum);
                int len = i - prevIdx;

                maxLen = Math.max(len,maxLen);
            }
        }
        System.out.println(sumIdx);
        System.out.println(maxLen);
    }
}

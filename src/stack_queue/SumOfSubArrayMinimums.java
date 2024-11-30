package stack_queue;

import java.util.Stack;

// It is different from Minimum sum SubArray . Do check it in YouTube(AlgorithmHQ/ CodeStoryWithMIK)
public class SumOfSubArrayMinimums {
    public static void main(String[] args) {

        int[] arr = {3,1,2,4};
        int ans = sumOfSubArrayMinimums(arr);
        System.out.println(ans);
    }

    private static int sumOfSubArrayMinimums(int[] arr) {

        int[] prevSmall = nextSmallerToLeft(arr);
        int[] nextSmall = nextSmallerToRight(arr);

        int mod = 1000000007;

        long count =0;

        for(int i=0; i<arr.length; i++){
            int first = i - prevSmall[i];
            int second = nextSmall[i] - i;

            int prod = (first * second) & mod;
            prod = (prod * arr[i]) % mod;


            count = (count%mod + prod)%mod;

        }

        return (int)count;

    }

    private static int[] nextSmallerToLeft(int[] arr){

        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i=0; i<arr.length; i++){

            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerToRight(int[] arr){

        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                ans[i] = arr.length;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }


}

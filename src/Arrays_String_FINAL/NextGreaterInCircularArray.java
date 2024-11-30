package Arrays_String_FINAL;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterInCircularArray {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,3};
        int[] ans = nextGreaterElementInCircularArray(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElementInCircularArray(int[] arr) {

        Stack<Integer> s = new Stack<>();
        s.push(arr[arr.length-1]);

        for(int i=arr.length-2; i>=0; i--){
            while(!s.isEmpty() && arr[i] >= s.peek()){
                s.pop();
            }
            s.push(arr[i]);
        }

        int[] ngr = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && arr[i] >= s.peek()){
                s.pop();
            }

            if(s.isEmpty()){
                ngr[i] = -1;
            }
            else{
                ngr[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return ngr;
    }
}

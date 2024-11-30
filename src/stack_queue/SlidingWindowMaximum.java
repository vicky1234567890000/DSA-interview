package stack_queue;

import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        Stack<Integer> s = new Stack<>();
        int[] ngr = new int[nums.length];

        ngr[nums.length-1] = nums.length;
        s.push(nums.length-1);

        for(int i=nums.length-2;i>=0;i--){

            while(!s.isEmpty() && nums[i] >= nums[s.peek()]){
                s.pop();
            }

            ngr[i] = s.isEmpty() ? nums.length : s.peek();
            s.push(i);
        }

        for(int x : ngr){
            System.out.print(x+" ");
        }
        System.out.println();

        int[] ans = new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<ans.length;i++){
            j=i;
            while(ngr[j] < i+k){
                j = ngr[j];
            }

            ans[i] = nums[j];
        }

        for(int x : ans){
            System.out.print(x+" ");
        }

    }

}

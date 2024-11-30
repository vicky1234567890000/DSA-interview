package stack_queue;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class LarAreaOfHistogram {

    public static void main(String[] args) {
        LarAreaOfHistogram obj = new LarAreaOfHistogram();

        System.out.println(obj.largestRectangleArea(new int[]{2,1,5,6,2,3}));

        List<Integer> l = List.of(2,1,5,6,2,3);
        Optional<Integer> max = l.stream().max(Comparator.naturalOrder());
        System.out.println(max.get());
    }
    public int largestRectangleArea(int[] arr) {

        int[] nsl = nextSmallerInLeft(arr);
        int[] nsr = nextSmallerInRight(arr);

        int maxArea = 0;
        for(int i=0; i<arr.length; i++){
            int width = nsr[i] - nsl[i]-1;
            int height = arr[i];

            int area = width * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }

    private int[] nextSmallerInLeft(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i=0; i<arr.length; i++){

            while(!s.isEmpty() && arr[i] < arr[s.peek()]){

                s.pop();
            }


            if(s.size() == 0){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    private int[] nextSmallerInRight(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && arr[i] <= arr[s.peek()]){
                s.pop();
            }


            if(s.size() == 0){
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

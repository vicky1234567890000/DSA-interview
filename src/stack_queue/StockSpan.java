package stack_queue;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args){

        int[] arr = {2,4,3,8,5,1,4,9,7};
        int[] span = stockSpan(arr);

        for(int x : span){
            System.out.print(x+" ");
        }

    }

    private static int[] stockSpan(int[] arr) {

        int[] span = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0]=1;

        for(int i=1;i<arr.length;i++){

            while(!s.isEmpty() && arr[i] > arr[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                span[i] = i - s.peek();
            }
            s.push(i);
        }

        return span;
    }
}

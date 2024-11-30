package stack_queue;

import java.util.Stack;

public class NGR {
    public static void main(String[] args){

        int[] arr = {2,3,1,5,4};
        int[] ngr = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        s.push(arr[arr.length-1]);
        ngr[arr.length-1]= -1;

        for(int i=arr.length-2;i>=0;i--){
            while(!s.isEmpty() && arr[i] > s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                ngr[i] = -1;
            }else{
                ngr[i] = s.peek();
            }
            s.push(arr[i]);
        }

        for(int x : ngr){
            System.out.print(x+" ");
        }
    }

}

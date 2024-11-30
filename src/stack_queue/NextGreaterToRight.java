package stack_queue;

import java.util.Stack;

public class NextGreaterToRight {
    public static void main(String[] args) {

        int[] arr = {4,6,1,2,-1,-5,2,0};
        int[] ngr = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        s.add(arr[arr.length-1]);
        ngr[ngr.length-1] = -1;

        for(int i=arr.length-2; i>= 0; i--){

            while(!s.isEmpty() && arr[i] >= s.peek()){
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

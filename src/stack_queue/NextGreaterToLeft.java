package stack_queue;

import java.util.Stack;

public class NextGreaterToLeft {

    public static void main(String[] args){

         int[] arr = {2,4,3,8,5,1,4,9,7};
         int i=0;
         Stack<Integer> s = new Stack<>();
         int[] res = new int[arr.length];

         s.add(i);
         res[0] = -1;

         for(i=1;i<arr.length;i++){

             while(!s.isEmpty() && arr[i] >= s.peek()){
                 s.pop();
             }

             if(s.isEmpty()){
                 res[i] = -1;
             }else{
                 res[i] = s.peek();
             }

             s.push(arr[i]);
         }

         for(int x : res){
             System.out.print(x+" ");
         }
    }
}

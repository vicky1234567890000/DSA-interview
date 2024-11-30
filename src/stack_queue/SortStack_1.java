package stack_queue;

import java.util.Stack;

public class SortStack_1 {
    public static void main(String[] args){

        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(5);
        s.push(4);

        Stack<Integer> res = sort(s);

        while(!res.isEmpty()){
            System.out.print(res.pop()+" ");
        }
    }

    private static Stack<Integer> sort(Stack<Integer> s) {

        Stack<Integer> temp = new Stack<>();
        temp.push(s.pop());

        while(!s.isEmpty()){

            int firstVal = s.pop();
            while(!temp.isEmpty()){

                if(firstVal < temp.peek()){
                    int secondVal = temp.pop();
                    s.push(secondVal);
                }else{
                    break;
                }
            }
            temp.push(firstVal);
        }

        return temp;
    }

}

package stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SortStack {

    public static void main(String[] args){

        Stack<Integer> input = new Stack<>();
        input.push(11);
        input.push(2);
        input.push(3);
        input.push(32);
        input.push(41);

        Stack<Integer> output = sort(input);

        while(!output.isEmpty()){
            System.out.print(input.pop()+" ");
        }
    }
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        //add code here.
        List<Integer> l = new ArrayList<>();

        while(!s.isEmpty()){
            l.add(s.pop());
        }
        Collections.sort(l);
        for (Integer integer : l) {
            s.push(integer);
        }
        return s;
    }
}

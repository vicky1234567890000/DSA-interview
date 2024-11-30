package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    public static void main(String[] args){

        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(4);
        stack.push(3);

        int val = stack.pop();
        System.out.println(val);

        int val1 = stack.pop();
        System.out.println(val1);

    }
    public void push(int a){

        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(a);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

    }

    public int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.remove();
    }



}

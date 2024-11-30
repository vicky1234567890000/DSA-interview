package stack_queue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public static void main(String[] args){

        MyQueue queue = new MyQueue();
        queue.push(2);
        queue.push(4);
        queue.push(3);

        int val = queue.pop();
        System.out.println(val);

        int val1 = queue.pop();
        System.out.println(val1);
    }
    public void push(int a){

        s1.push(a);

    }
    public int pop(){

        if(s1.isEmpty()) return -1;

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int val = s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return val;
    }



}

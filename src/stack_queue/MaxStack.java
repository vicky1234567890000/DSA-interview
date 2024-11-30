package stack_queue;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> s,max;
    MaxStack(){
        s = new Stack<>();
        max = new Stack<>();
    }
    public void push(int a){
        s.push(a);
        int m = a;
        if(!max.isEmpty()){
            m = Math.max(m,max.peek());
        }
        max.push(m);
    }
    public int pop(){
        max.pop();
        return s.pop();
    }
    public int top(){
        return s.peek();
    }
    public int peekMax(){
        return max.peek();
    }

    public int popMax(){

        int tbr = max.peek();
        Stack<Integer> buffer = new Stack<>();
        while(s.peek() != tbr){
            buffer.push(pop());
            //max.pop();
        }
        pop();
        while(!buffer.isEmpty()){
            push(buffer.pop());
        }
        return tbr;

    }
    public static void main(String[] args){

        MaxStack stack = new MaxStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("peekMax : " + stack.peekMax());
        System.out.println("popMax - 1 : " + stack.popMax());
        System.out.println("popMax - 2 : " + stack.popMax());
        System.out.println("popMax - 3 : " + stack.popMax());

    }
}

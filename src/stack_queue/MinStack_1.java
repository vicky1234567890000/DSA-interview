package stack_queue;

import java.util.Stack;

public class MinStack_1 {

    private final Stack<Integer> minStack;
    private Stack<Integer> s;

    public MinStack_1(){
        this.minStack = new Stack<>();
        this.s = new Stack<>();
    }
    public void push(int a){

        s.push(a);
        int min = a;
        if(!minStack.isEmpty())
           min = Math.min(min,minStack.peek());
        minStack.push(min);
    }
    public int pop(){
        minStack.pop();
        return s.pop();
    }
    public int peek(){
        return s.peek();
    }
    public int peekMin(){
        return minStack.peek();
    }
    public int popMin(){
        int tbr = minStack.peek();
        Stack<Integer> buffer = new Stack<>();
        while(s.peek() != tbr){
            buffer.push(pop());
        }
        pop();
        while(!buffer.isEmpty()){
            push(buffer.pop());
        }
        return tbr;
    }
    public static void main(String[] args){

        MinStack_1 minStack1 = new MinStack_1();
        minStack1.push(2);
        minStack1.push(3);
        minStack1.push(1);
        minStack1.push(5);
        minStack1.push(4);

        System.out.println("peek min : " + minStack1.peekMin());
        System.out.println("popped min : " + minStack1.popMin());
        System.out.println(("peek min : " + minStack1.peekMin()));

        while(!minStack1.s.isEmpty()){
            System.out.print(minStack1.s.pop()+" ");
        }

    }
}

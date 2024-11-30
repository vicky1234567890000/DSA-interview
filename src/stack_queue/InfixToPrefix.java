package stack_queue;

import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args){

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String prefix_exp = infixToPrefix(exp);
        System.out.println(prefix_exp);
    }
    public static String infixToPrefix(String exp) {

        Stack<String> prefix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0;i<exp.length();i++){

            char ch = exp.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }else if(ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^'){
                // ch is allowing higher precedence operators to be executed first.
                while(!operators.isEmpty() && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    char optor = operators.pop();
                    String prefixV2 = prefix.pop();
                    String prefixV1 = prefix.pop();
                    String res = optor + prefixV1 + prefixV2;
                    prefix.push(res);
                }
                // ch is pushing itself.
                operators.push(ch);
            }else if(ch == ')'){
                while(operators.peek() != '('){
                    char optor = operators.pop();
                    String prefixV2 = prefix.pop();
                    String prefixV1 = prefix.pop();
                    String res = optor + prefixV1 + prefixV2;
                    prefix.push(res);
                }
                operators.pop();
            }else if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')){
                prefix.push(ch + "");
            }
        }

        while(!operators.isEmpty()){
            char optor = operators.pop();
            String prefixV2 = prefix.pop();
            String prefixV1 = prefix.pop();
            String res = optor + prefixV1 + prefixV2;
            prefix.push(res);
        }
        return prefix.peek();

    }

    private static int precedence(char ch){

        return switch(ch){
            case '+','-' -> 1;
            case '*','/' -> 2;
            default -> 3;
        };
    }

}

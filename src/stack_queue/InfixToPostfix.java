package stack_queue;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args){

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix_exp = infixToPostfix(exp);
        System.out.println(postfix_exp);
    }
    public static String infixToPostfix(String exp) {

        Stack<String> postfix = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0;i<exp.length();i++){

            char ch = exp.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }else if(ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^'){
                // ch is allowing higher precedence operators to be executed first.
                while(!operators.isEmpty() && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    char optor = operators.pop();
                    String postfixV2 = postfix.pop();
                    String postfixV1 = postfix.pop();
                    String res = postfixV1 + postfixV2 + optor;
                    postfix.push(res);
                }
                // ch is pushing itself.
                operators.push(ch);
            }else if(ch == ')'){
                while(operators.peek() != '('){
                    char optor = operators.pop();
                    String postfixV2 = postfix.pop();
                    String postfixV1 = postfix.pop();
                    String res = postfixV1 + postfixV2 + optor;
                    postfix.push(res);
                }
                operators.pop();
            }else if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')){
                postfix.push(ch + "");
            }
        }

        while(!operators.isEmpty()){
            char optor = operators.pop();
            String postfixV2 = postfix.pop();
            String postfixV1 = postfix.pop();
            String res = postfixV1 + postfixV2 + optor;
            postfix.push(res);
        }
        return postfix.peek();

    }

    private static int precedence(char ch){

        return switch(ch){
            case '+','-' -> 1;
            case '*','/' -> 2;
            default -> 3;
        };
    }

}

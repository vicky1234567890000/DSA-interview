package stack_queue;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args){

        String exp = "2+(5-3*6/2)";
        String exp1 = "2+3/4-(5*6)";
        int res = evaluateInfixExpression(exp1);

        System.out.println(res);

    }

    private static int evaluateInfixExpression(String exp) {

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<exp.length();i++){
            char ch = exp.charAt(i);

            if(Character.isDigit(ch)){
                operands.push(ch-'0');
            }else if(ch == '('){
                operators.push(ch);
            }else if(ch == ')'){
                //pops all the operators till '('.
                while(operators.peek() != '('){
                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int res = evaluate(v1,v2,optor);
                    operands.push(res);
                }
                //pops the '(' as well.
                operators.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                // ch is wanting higher priority operators to be evaluated first.
                while(!operators.isEmpty() && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())){
                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    int res = evaluate(v1,v2,optor);
                    operands.push(res);
                }
                // ch is pushing itself.
                operators.push(ch);
            }
        }

        while(!operators.isEmpty()){
            char optor = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            int res = evaluate(v1,v2,optor);
            operands.push(res);
        }

        return operands.peek();
    }
    private static int evaluate(int v1,int v2,char operator){

        return switch (operator){
            case '+' -> v1 + v2;
            case '-' -> v1 - v2;
            case '*' -> v1 * v2;
            default -> v1 / v2;
        };
    }
    private static int precedence(char ch){

        return switch (ch) {
            case '+', '-' -> 1;
            default -> 2;
        };

    }


}

package stack_queue;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args){

        String str = "([]){";
        boolean res = isValid(str);
        System.out.println(res);
    }
    private static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        if(str.length() == 0) return true;
        boolean result = false;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                result = handleEnclosing(s,ch);
                if(result==false) break;
            }
        }

        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean handleEnclosing(Stack<Character> s, char ch){

        if(s.isEmpty()){
            s.push(ch);
            return false;
        }

        if(!s.isEmpty() && ch == ')'){
            if(s.peek() == '('){
                s.pop();
            }else{
                return false;
            }
        }

        if(!s.isEmpty() && ch == ']'){
            if(s.peek() == '['){
                s.pop();
            }else{
                return false;
            }
        }

        if(!s.isEmpty() && ch == '}'){
            if(s.peek() == '{'){
                s.pop();
            }else{
                return false;
            }
        }

        return true;

    }
}

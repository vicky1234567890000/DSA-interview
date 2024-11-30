package java8_finalprep;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = "abca";
        boolean ans = validPalindrome(s);
        System.out.println(ans);
    }

    public  static boolean validPalindrome(String s) {
        boolean exp1 = true;
        boolean exp2  = true;
        int i=0; int j=s.length() - 1;
        int n = s.length();
        char[] chars = s.toCharArray();
        while(i < j){
            if(chars[i] != chars[j]){
                i++;

               exp1 = checkPalindrome(s,i,j);

                i--;
                j--;

                exp2 = checkPalindrome(s,i,j);

                break;
            }
            i++;
            j--;
        }

        return exp1 || exp2 ;
    }

    private static boolean checkPalindrome(String s, int i, int j) {

        if(i==j){
            return true;
        }
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

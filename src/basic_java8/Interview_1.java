package basic_java8;

import java.util.ArrayList;

//2 inputs 1 String and 1 int
//output : all consecutive substring of the length given
//
//
//
//example: inputs: abc 2
//         output: {ab,bc}
//         inputs: abcde 3
//         output: {abc,bcd,cde}
public class Interview_1 {
    public static void main(String[] args) {
        String str = "abc";
        int len = 2;

        printSubstrings(str,len);
    }
    private static void printSubstrings(String str, int len) {
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<len;i++){
                String ans = str.substring(i,len);
                res.add(ans);

        }
        System.out.println(res);
    }
}

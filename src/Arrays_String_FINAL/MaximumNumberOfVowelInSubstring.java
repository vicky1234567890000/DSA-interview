package Arrays_String_FINAL;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
// solved by Sumit Sir in 90 days prep
public class MaximumNumberOfVowelInSubstring {

    public static void main(String[] args) {
        String str = "leetcoed";

        int ans = maxVowels(str,3);
        System.out.println(ans);
    }

    public static int maxVowels(String str, int k){

        int max = 0;

        List<Character> l = new ArrayList<>();
        int vc = 0;
        for(int i=0; i<k; i++){
            char ch = str.charAt(i);
            l.add(ch);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vc++;
            }
        }

        max = vc;

        for(int i=k; i< str.length(); i++){
            char pch = str.charAt(i - k);
            l.remove(0);
            if(pch == 'a' || pch == 'e' || pch == 'i' || pch == 'o' || pch == 'u'){
                vc--;
            }
            char ch = str.charAt(i);
            l.add(ch);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vc++;
            }

            if(vc > max){
                max = vc;
            }
        }
        return max;
    }
}

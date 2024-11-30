package hashamapandheap.slidingwindow.irritating_problem;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {

        String str = "aabcbcdbca";
        int i = -1;


        HashMap<Character,Integer> fmap = new HashMap<>();
        int j = -1;
        int maxLen = 0;

        while(true) {

            boolean f1 = false;
            boolean f2 = false;
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if (fmap.get(ch) == 2) {
                    break;
                } else {
                    int len = i - j;
                    maxLen = Math.max(maxLen, len);
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j);
                fmap.put(ch, fmap.get(ch) - 1);

                if (fmap.get(ch) == 1) {
                    break;
                }
            }
            if(!f1 && !f2) break;
        }
        System.out.println(maxLen);
    }
}

package hashamapandheap.slidingwindow;

import java.util.HashMap;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
// https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {


        String S = "AABAABB";
        int K = 2;

        int ans = characterReplacement(S,K);
        System.out.println(ans);
    }

    private static int characterReplacement(String S, int K) {

        int maxLen = 0;
        int maxCount = 0;
        HashMap<Character,Integer> fmap = new HashMap<>();
        int left = 0;

        for(int right=0; right<S.length(); right++){

            char chR = S.charAt(right);
            fmap.put(chR, fmap.getOrDefault(chR,0)+1);

            maxCount = Math.max(maxCount, fmap.get(chR));
            int nonRepeating = (right - left + 1) - maxCount;

            if(nonRepeating > K){
                char chL = S.charAt(left);
                fmap.put(chL, fmap.get(chL)-1);
                left++;
            }

            maxLen = Math.max(maxLen, (right - left + 1));
        }


        return maxLen;
    }
}

package hashmap_Level2;

import java.util.HashMap;

public class LongestSubstringWithNoRepeatingCharacter {

    public static void main(String[] args) {
        String input = "abbacbcdbadbdbbdcb";
        int ans = longestSubstring(input);
        System.out.println(ans);
    }

    private static int longestSubstring(String input) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> fmap = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < input.length() - 1) {
                f1 = true;
                i++;
                char ch = input.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
                if (fmap.get(ch) == 2) {
                    break;
                } else {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                }

            }

            while (j < i) {
                f2 = true;
                j++;
                char ch = input.charAt(j);
                fmap.put(ch, fmap.get(ch) - 1);
                if (fmap.get(ch) == 1) {
                    break;
                }

            }
            if (!f1 && !f2) break;

        }
        return ans;
    }
}

package hashmap_Level2;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args){
        String str = "aabcbcdbca";
        int k = 2;
        int ans = 0;
        HashMap<Character,Integer> fmap = new HashMap<>();
        int i=-1;
        int j=-1;

        while(true) {

            boolean f1 = false,f2 = false;
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if (fmap.size() < k) {
                    continue;
                } else if (fmap.size() == k) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                } else {
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j);
                if (fmap.get(ch) == 1) {
                    fmap.remove(ch);
                } else {
                    fmap.put(ch, fmap.get(ch) - 1);
                }

                if (fmap.size() > k) {
                    continue;
                } else if (fmap.size() == k) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                    break;
                }
            }
            if(!f1 && !f1) break;
        }
        System.out.println(ans);
    }
}

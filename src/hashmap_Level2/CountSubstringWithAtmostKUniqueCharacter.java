package hashmap_Level2;

import java.util.HashMap;

public class CountSubstringWithAtmostKUniqueCharacter {

    public static void main(String[] args){
        String str = "aabcbcdbca";
        HashMap<Character,Integer> fmap = new HashMap<>();
        int count = 0; int k = 2;
        int i = -1;int j = -1;


        while(true) {
            while (i < str.length() - 1) {
                i++;
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if (fmap.size() <= k) {
                    count += (i - j);
                } else {
                    break;
                }
            }

            if( i == str.length()-1 && fmap.size() <=k ) {
                break;
            }
            while (j < i) {
                j++;
                char ch = str.charAt(j);
                if (fmap.get(ch) == 1) {
                    fmap.remove(ch);
                } else {
                    fmap.put(ch, fmap.get(ch) - 1);
                }

                if (fmap.size() > k) continue;

                else {
                    count += (i - j);
                    break;
                }
            }

        }

        System.out.println(count);
    }
}

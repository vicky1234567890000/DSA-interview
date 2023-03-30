package hashmap_Level2;

import java.util.HashMap;

public class CountAllSubstringsWithKUniqueCharacters {

    public static void main(String[] args) {
        String str = "abcabdabbcfa";
        int k = 2;
        int count = 0;
        int is = -1;
        int ib = -1;
        int j = -1;

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> bmap = new HashMap<>();

        while (true) {
            boolean f1 = false, f2 = false, f3 = false;
            while (ib < str.length() - 1) {
                f1 = true;
                ib++;
                char ch = str.charAt(ib);
                bmap.put(ch, bmap.getOrDefault(ch, 0) + 1);

                if (bmap.size() == k+1) {
                    removeInMap(bmap, ch);
                    ib--;
                    break;
                }
            }

            while (is < ib) {
                f2 = true;
                is++;
                char ch = str.charAt(is);
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);

                if (smap.size() == k) {
                    removeInMap(smap, ch);
                    is--;
                    break;
                }
            }

            while (j < is) {
                f3 = true;
                if (bmap.size() == k && smap.size() == k - 1) {
                    count += (ib - is);
                }

                j++;
                char ch = str.charAt(j);
                removeInMap(bmap, ch);
                removeInMap(smap, ch);

                if (smap.size() < k - 1 || bmap.size() < k) {
                    break;
                }
            }
            if (!f1 && !f2 && !f3) break;
        }
        System.out.println(count);
    }

    private static void removeInMap(HashMap<Character, Integer> map, char ch) {

        if (map.get(ch) == 1) {
            map.remove(ch);
        } else {
            map.put(ch, map.get(ch) - 1);
        }

    }
}

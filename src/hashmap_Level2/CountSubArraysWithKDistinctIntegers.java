package hashmap_Level2;

import java.util.HashMap;


public class CountSubArraysWithKDistinctIntegers {

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;

        int is = -1;
        int ib = -1;
        int j = -1;
        int count = 0;

        HashMap<Integer, Integer> bmap = new HashMap<>();
        HashMap<Integer, Integer> smap = new HashMap<>();

        while (true) {

            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            while (ib < arr.length - 1) {
                f1 = true;
                ib++;

                int val = arr[ib];
                bmap.put(val, bmap.getOrDefault(val, 0) + 1);

                if (bmap.size() == k + 1) {
                    removeInMap(bmap, val);
                    ib--;
                    break;
                }
            }

            while (is < ib) {
                f2 = true;
                is++;

                int val = arr[is];
                smap.put(val, smap.getOrDefault(val, 0) + 1);

                if (smap.size() == k) {
                    removeInMap(smap, val);
                    is--;
                    break;
                }
            }

            while (j < is) {
                f3 = true;

                if(bmap.size() == k && smap.size() == k-1){
                    count += (ib - is);
                }
                j++;
                int val = arr[j];
                removeInMap(smap, val);
                removeInMap(bmap, val);

                if(bmap.size() < k || smap.size() < k-1){
                    break;
                }


            }

            if(f1 && f2 && f3) break;
        }
        System.out.println(count);
    }

    private static void removeInMap(HashMap<Integer, Integer> map, int val) {

        if(map.get(val) == 1){
            map.remove(val);
        }else {
            map.put(val,map.get(val)-1);
        }
    }
}

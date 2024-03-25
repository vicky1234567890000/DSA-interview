package hashamapandheap.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://www.codingninjas.com/studio/problems/anagram-mapping_3125901?leftPanelTabValue=PROBLEM
public class FindAnagramMappings {

    private static class Pair{
        private int idx=0;
        private List<Integer> al;

        Pair(int idx, List<Integer> al){
            this.idx = idx;
            this.al = al;
        }
    }
    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50};
        int[] b = {20, 10, 40, 50, 30};

        int[] ans = findAnagramsMapping(a,b);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findAnagramsMapping(int[] a, int[] b) {

        HashMap<Integer, Pair> map = new HashMap<>();

        for(int i=0; i<b.length; i++){
            if(!map.containsKey(b[i])){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(b[i],new Pair(0,l));
            }else{
                Pair p = map.get(b[i]);
                p.al.add(i);
            }
        }

        int[] ans = new int[a.length];
        for(int i=0; i<a.length; i++){
            Pair p = map.get(a[i]);
            ans[i] = p.al.get(p.idx);
            p.idx++;
        }
        return ans;
    }
}

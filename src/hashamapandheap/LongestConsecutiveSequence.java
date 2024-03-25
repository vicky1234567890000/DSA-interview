package hashamapandheap;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {10,5,9,1,11,8,6,15,3,12,2};
        int longestSeq = longestConsecutiveSeq(arr);
        System.out.println();
        System.out.println(longestSeq);
    }

    private static int longestConsecutiveSeq(int[] arr) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int val : arr){
            map.put(val,true);
        }

        for(int val : arr){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }

        int sp = 0;
        int ml = 0;

        for(int val : arr){
            if(map.get(val)){
                int csp = val;
                int cl = 1;
                while(map.containsKey(val + cl)){
                    cl++;
                }
                if(cl > ml){
                    ml = cl;
                    sp = csp;
                }
            }


        }

        for(int l=0; l<ml; l++){
            System.out.print(sp + l +" ");
        }
        return ml;
    }
}

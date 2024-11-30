package hashamapandheap.anagram;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
public class FindAllAnagrams {
    public static void main(String[] args) {
        String str = "aabaabaa";
        String pstr = "aaba";


        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();

        for(int i=0; i<pstr.length(); i++){
            char ch = str.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        int i=0;
        for(; i<pstr.length(); i++){
            char ch = pstr.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }




        int count = 0;
        while(i < str.length()){

            if(compare(smap,pmap)){
                count++;
            }

            char cha = str.charAt(i);
            smap.put(cha, smap.getOrDefault(cha,0)+1);

            char chr = str.charAt(i - pstr.length());
            int freq = smap.get(chr);
            if(freq == 1){
                smap.remove(chr);
            }else{
                smap.put(chr, smap.get(chr)-1);
            }
            i++;
        }
        if(compare(smap,pmap)){
            count++;
        }

        System.out.println(count);
    }

    private static boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {

        for(Character ch : smap.keySet()){

            if(!pmap.getOrDefault(ch, 0).equals(smap.get(ch))){
                return false;
            }
        }
        return true;
    }
}

package hashmap_Level2;

import java.util.HashMap;
import java.util.Objects;

public class FindAllAnagramsInAString {

    public static void main(String[] args){
        String ss = "abbacdadcbab";
        String ps = "abbc";
        int count = 0;

        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();

        int i = ps.length();

        for(int x=0;x<ps.length();x++){
            char ch = ps.charAt(x);
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        }

        for(int y=0;y<ps.length();y++){
            char ch = ss.charAt(y);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
        }

        while(i < ss.length()){

            if(compareMap(smap,pmap)) {
                count ++;
                for(int z = (i-ps.length()); z<i; z++)
                System.out.print(ss.charAt(z));
            }
            System.out.print(" ");
            char ch_acquired = ss.charAt(i);
            smap.put(ch_acquired,smap.getOrDefault(ch_acquired,0)+1);

            char ch_released = ss.charAt(i-ps.length());
            if(smap.get(ch_released) == 1){
                smap.remove(ch_released);
            }else{
                smap.put(ch_released,smap.get(ch_released)-1);
            }

            i++;
        }
        if(compareMap(smap,pmap)) {
            count ++;
            for(int z = (i-ps.length()); z<i; z++)
                System.out.print(ss.charAt(z));
        }
        System.out.println();
        System.out.println(count);
    }

    private static boolean compareMap(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {

        for(Character ch : smap.keySet()){
            if(pmap.getOrDefault(ch, 0) != smap.get(ch)){
                return false;
            }
        }

        return true;

    }
}

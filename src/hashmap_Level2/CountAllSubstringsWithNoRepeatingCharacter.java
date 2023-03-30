package hashmap_Level2;

import java.util.HashMap;

public class CountAllSubstringsWithNoRepeatingCharacter {

    public static void main(String[] args){
        String str = "abbd";
        HashMap<Character,Integer> fmap = new HashMap<>();
        int i = -1;
        int j = -1;

        int count = 0;
        while(true) {

            boolean f1 = false;
            boolean f2 = false;
            while(i < str.length() - 1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
                if(fmap.get(ch) == 2){
                    break;
                }else{
                    count += (i-j);
                }
            }

            while(j < i){
                f2 = true;
                j++;
                char ch = str.charAt(j);
                fmap.put(ch,fmap.get(ch)-1);

                if(fmap.get(ch)==1){
                    count += (i-j);
                    break;
                }
            }
            if(!f1 && !f2) break;
        }
        System.out.println(count);
    }
}

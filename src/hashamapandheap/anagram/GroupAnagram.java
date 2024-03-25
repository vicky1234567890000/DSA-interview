package hashamapandheap.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {

        String words[] = {"no","on","is"};
        List<List<String>> ans = anagrams(words);
        System.out.println(ans);
    }

    public static List<List<String>> anagrams(String[] list) {
        // Code here

        HashMap<HashMap<Character,Integer>, ArrayList<String>> bmap = new HashMap<>();
        for(String str : list){

            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            if(!bmap.containsKey(map)){

                ArrayList<String> l = new ArrayList<>();
                l.add(str);
                bmap.put(map,l);
            }else{
                ArrayList<String> l = bmap.get(map);
                l.add(str);
                l.stream().sorted();
            }

        }

        List<List<String>> ans = new ArrayList<>();
        for(ArrayList<String> l : bmap.values()){
            ans.add(l);
        }

        return ans;


    }

}

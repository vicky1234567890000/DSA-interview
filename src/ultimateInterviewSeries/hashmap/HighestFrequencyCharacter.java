package ultimateInterviewSeries.hashmap;

import java.util.HashMap;
import java.util.Locale;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        String s = "banana";
        String[] strArr = s.toLowerCase(Locale.ROOT).split("");
        HashMap<String,Integer> hmap = new HashMap<>();
        for(String str : strArr){
            if(!hmap.containsKey(str)) hmap.put(str,1);
            else{
                Integer cf = hmap.get(str);
                hmap.put(str,cf+1);
            }
        }
        System.out.println(hmap);
        String maxFreqChar = strArr[0];
        for(String key : hmap.keySet()){
            if(hmap.get(key) > hmap.get(maxFreqChar)){
                maxFreqChar = key;
            }
        }
        System.out.println("Max Freq Character is : "+ maxFreqChar);
    }
}

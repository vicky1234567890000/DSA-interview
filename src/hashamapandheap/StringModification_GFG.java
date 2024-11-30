package hashamapandheap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reorganize-string/description/
// https://practice.geeksforgeeks.org/problems/string-modification-1587115621/1
public class StringModification_GFG {
    public static class Pair{
        char ch;
        int freq;

        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String rearrangeString(String str)
    {
        //Your code here
        if(str.length() == 1) return str;
        int[] map = new int[26];

        for(int i=0; i<str.length(); i++){


            map[str.charAt(i) - 'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(p -> p.freq)));

        for(int i=0; i<26; i++){


            if(map[i] > 0){
                pq.add(new Pair((char)('a'+i),map[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        Pair block = pq.poll();
        sb.append(block.ch);
        block.freq--;


        while(pq.size() > 0){

            Pair temp = pq.poll();
            sb.append(temp.ch);
            temp.freq--;

            if(block.freq > 0){
                pq.add(block);
            }

            block = temp;

        }

        if(sb.length() != str.length()) return "";
        return sb.toString();


    }
    public static void main(String[] args) {

        System.out.println(rearrangeString("aab"));
    }
}

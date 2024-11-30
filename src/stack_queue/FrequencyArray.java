package stack_queue;

public class FrequencyArray {
    public static void main(String[] args){

        String str = "banana";
        int[] freq = new int[26];

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
        }

        for(int i : freq){
            System.out.print(i+" ");
        }
    }

}

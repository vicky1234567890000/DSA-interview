package final_prep;

public class IsSubSequence {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ahbgdc";

        int i=0;
        int j=0;

        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        System.out.println(i == str1.length());

    }
}

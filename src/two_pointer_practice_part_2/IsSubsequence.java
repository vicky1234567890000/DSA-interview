package two_pointer_practice_part_2;

public class IsSubsequence {
    public static void main(String[] args) {

        String str1 = "AXY";
        String str2 = "YADXCP";

        boolean result = isSubSequence(str1, str2);
        System.out.println(result);
    }

    private static boolean isSubSequence(String str1, String str2) {

        int i=0;
        int j=0;

        while(i < str1.length() && j < str2.length()){

            if(str1.charAt(i) == str2.charAt(j)){
                i++;
            }
            j++;
        }
        return i==str1.length();
    }
}

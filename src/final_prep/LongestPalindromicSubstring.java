package final_prep;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        String str = "aabbaa";

        String ans = longestPalindromicSubString(str);
        System.out.println(ans);
    }

    private static String longestPalindromicSubString(String str) {

        String LPS = "";
        if(str.length() <= 1) return str;
        for(int i=1; i<str.length(); i++){


            int l = i;
            int r = i;

            while(str.charAt(l) == str.charAt(r)){
                l--;
                r++;

                if(l == -1 || r==str.length()){
                    break;
                }

            }

            String palindromicSubString = str.substring(l + 1, r);
            if(palindromicSubString.length() > LPS.length()){
                LPS = palindromicSubString;
            }

             l = i-1;
             r = i;

            while(str.charAt(l) == str.charAt(r)){
                l--;
                r++;

                if(l == -1 || r==str.length()){
                    break;
                }

            }

            palindromicSubString = str.substring(l + 1, r);
            if(palindromicSubString.length() > LPS.length()){
                LPS = palindromicSubString;
            }


        }
        return LPS;

    }
}

package final_prep;

// https://leetcode.com/problems/string-compression/description/
public class CompressString {
    public static void main(String[] args) {
        String str = "aaaabbbccddddde";

        String ans = compressString(str);
        System.out.println(ans);
    }

    private static String compressString(String str) {

        String[] arr = str.split("");
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int i=1;
        for(; i<str.length(); i++){

            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }

            else{
                sb.append(str.charAt(i-1));
                if(count > 1){
                    sb.append(count);
                }
                count = 1;
            }
        }

        sb.append(str.charAt(i-1));
        if(count > 1){
            sb.append(count);
        }
        return sb.toString();
    }
}

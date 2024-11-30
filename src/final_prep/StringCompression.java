package final_prep;

public class StringCompression {
    public static void main(String[] args) {
        String str = "AAAABBBBBBCCCCD";
        String ans = stringCompression(str);
        System.out.println(ans);
    }

    private static String stringCompression(String str) {

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int count = 1;

        for(int i=1; i<str.length(); i++){

            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }
            else{
                if(count > 1){
                    sb.append(count);
                }
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        if(count > 1){
            sb.append(count);
        }
        return sb.toString();
    }

}

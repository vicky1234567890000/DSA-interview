package twopointer;

public class MinimumSwapsToMakeStringsEqual {
    public static void main(String[] args){
       String s1 = "xy";
       String s2 = "yx";

       int ans = minimumSwaps(s1,s2);
       System.out.println(ans);
    }

    private static int minimumSwaps(String s1, String s2) {

        int xy=0,yx=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(s1.charAt(i) == 'x'){
                    xy++;
                }else{
                    yx++;
                }
            }
        }

        if(xy%2 != yx%2) return -1;
        else return xy/2 + yx/2 + (xy%2)*2;

    }
}

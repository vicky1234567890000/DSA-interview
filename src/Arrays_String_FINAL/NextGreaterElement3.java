package Arrays_String_FINAL;

// https://leetcode.com/problems/next-greater-element-iii/description/
// https://www.youtube.com/watch?v=eAfJJyaAmes&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=8
public class NextGreaterElement3 {
    public static void main(String[] args) {

        int n = 2154754;
        int ans = nextGreaterElement(n);
        System.out.println(ans);
    }

    private static int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        char[] chArr = str.toCharArray();


        int j = chArr.length - 1;
        int k = 0;
        while(j >= 1){
            if(chArr[j] <= chArr[j-1]) j--;
            else{
                k = j-1;
                break;
            }
        }
        if(j == 0) return -1;
        int l = 0;
        for(int i=k+1; i<chArr.length; i++){
            if(chArr[i] > chArr[k]){
                l = i;
            }
        }
        swap(chArr, l, k);

        int x = k+1;
        int y = chArr.length-1;

        while(x < y){
            swap(chArr, x, y);
            x++;
            y--;
        }

        return Integer.parseInt(new String(chArr));
    }

    private static void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}

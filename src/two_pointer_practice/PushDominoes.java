package two_pointer_practice;

public class PushDominoes {
    public static void main(String[] args) {
        //String str = ".L.R....LR...L.R";
        String str = "RR.L";
        String res = pushDominoes(str);
        System.out.println(res);
    }

    private static String pushDominoes(String str) {
        int n = str.length();
        char[] chArr = new char[n+2];
        chArr[0] = 'L';
        chArr[n+1] = 'R';

        for(int i=n-1; i>=0; i--){
            chArr[i+1] = str.charAt(i);
        }

        int j=0;
        int k = 1;

        while(k < chArr.length) {

            while(chArr[k] == '.') k++;
            if(k - j > 1) {
                solveConfiguration(chArr, j, k);
            }
            j = k;
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<chArr.length-1; i++){
            sb.append(chArr[i]);
        }
        return sb.toString();
    }

    private static void solveConfiguration(char[] chArr, int i, int j) {

        if(chArr[i] == 'L' && chArr[j] == 'L'){
            for(int k=i+1; k<j; k++){
                chArr[k] = 'L';
            }
        } else if(chArr[i] == 'R' && chArr[j] == 'R'){
            for(int k=i+1; k<j; k++){
                chArr[k] = 'R';
            }
        } else if(chArr[i] == 'L' && chArr[j] == 'R'){
            // no dominoes will be affected.
        } else {
            int diff = j - i;
            int mid = (i+j)/2;
            if(diff % 2 != 0) { // even members in gap
                for(int k=i+1; k<=mid; k++){
                    chArr[k] = 'L';
                }
                for(int k=mid+1; k<j; k++){
                    chArr[k] = 'R';
                }
            } else { // odd members in gap
                for(int k=i+1; k < mid; k++){
                    chArr[k] = 'L';
                }
                for(int k=mid+1; k<j; k++){
                    chArr[k] = 'R';
                }
            }
        }
    }
}

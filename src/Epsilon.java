import java.util.Arrays;

public class Epsilon {

    public static void main(String[] args) {
//        int[] arr = {2,0,1,1,0,2,1,0,2,1,1,1};
//
//        int i=0;
//        int j=0;
//
//        int k = arr.length - 1;
//
//        while(i <= k){
//
//            if(arr[i] == 1){
//                swap(arr,i,j);
//                i++;
//                j++;
//            } else if(arr[i] == 2){
//                i++;
//            } else{
//                swap(arr,i,k);
//                k--;
//            }
//        }
//        System.out.println(Arrays.toString(arr));


        String str = "abbbavvvdad";

        int i = 1;
        int j = 1;

        int maxLen = 0;
        for(int x=0; x<str.length(); x++){

            if(i == 0 || j == str.length()){
                break;
            }

            if(str.charAt(i) == str.charAt(j)){
                int len = j - i;
                if(len > maxLen){
                    maxLen = len;
                }
            }

            i--;
            j++;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

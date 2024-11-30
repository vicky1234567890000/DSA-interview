package Arrays_String_FINAL;

// https://leetcode.com/problems/first-missing-positive/submissions/1315037687/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {100, 101, 200, -1, 0};

        int ans = firstMissingPositive(arr);
        System.out.println(ans);
    }

    private static int firstMissingPositive(int[] arr) {

        boolean[] booleanArray = new boolean[arr.length];
        int n = arr.length;
        for(int i=0; i<n; i++){

            if(arr[i] <= 0 || arr[i] > n){
                continue;
            }

            booleanArray[arr[i]] = true;
        }

        int x=1;
        for(; x<n; x++){
            if(!booleanArray[x]){
                break;
            }
        }
        return x;
    }
}

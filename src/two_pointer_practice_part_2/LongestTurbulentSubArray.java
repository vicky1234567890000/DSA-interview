package two_pointer_practice_part_2;

// https://leetcode.com/problems/longest-turbulent-subarray/description/
// solution video = https://www.youtube.com/watch?v=0oRxJeENc7w
public class LongestTurbulentSubArray {
    public static void main(String[] args) {

        int[] arr = {9,4,2,10,7,8,8,1,9};
        int maxLen = maxTurbulenceSize(arr);
        System.out.println(maxLen);
    }

    private static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        if(n==1) return 1;
        if(n==2 && arr[0] != arr[1]) {
            dp[1] = dp[0] + 1;
            return dp[1];
        }


        for(int i=1; i<n-1; i++){
            if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                dp[i] = dp[i-1] + 1;
            }
            else if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                dp[i] = dp[i-1] + 1;
            }
            else if(arr[i] == arr[i-1] && arr[i] == arr[i+1]){
                dp[i] = 0;
            }
            else{
                dp[i] = 1;
            }
        }

        int maxLen = 0;
        for(int i=1; i<n; i++){
            if(maxLen < dp[i]){
                maxLen = dp[i];
            }
        }
        return maxLen + 1;
    }
}

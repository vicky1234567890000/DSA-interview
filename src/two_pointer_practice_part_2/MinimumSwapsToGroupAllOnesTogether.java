package two_pointer_practice_part_2;

// https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1
public class MinimumSwapsToGroupAllOnesTogether { // This is for Circular Array
    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 0, 1, 1};
        int minSwaps = minSwapsRequiredToGroupAllOnesTogether(arr);
        System.out.println(minSwaps);
    }

    private static int minSwapsRequiredToGroupAllOnesTogether(int[] arr) {

        int n = arr.length;
        int window = 0;
        for(int e : arr){
            if(e == 1) window++;
        }

        int czeros = 0;
        int ans = 0;
        for(int i=0; i<window; i++){
            if(arr[i] == 0){
                czeros++;
            }
        }
        ans = czeros;
        for(int i=window; i < 2*n; i++){

            if(arr[i % n] == 0){
                czeros ++;
            }
            if(arr[(i - window) % n] == 0){
                czeros--;
            }

            ans = Math.min(ans, czeros);
        }
        return ans;
    }
}

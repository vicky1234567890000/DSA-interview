package two_pointer_practice_part_2;

// https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1
public class MinimumSwapsToGroupAllOnesTogether_1 { // This is for non-circular array
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 1};
        int minSwaps = minimumSwapsToGroupAllOnesTogether(arr);
        System.out.println(minSwaps);
    }

    private static int minimumSwapsToGroupAllOnesTogether(int[] arr) {
        int n = arr.length;
        if(n==1 && arr[0] == 0) return -1;

        int sum = 0;
        int window = 0;
        for(int e : arr){
            if(e == 1) window++;
            sum += e;
        }
        if(sum == 0) return -1;

        int czeros = 0;
        int ans = 0;
        for(int i=0; i<window; i++){
            if(arr[i] == 0){
                czeros++;
            }
        }
        ans = czeros;
        for(int i=window; i < n; i++){

            if(arr[i] == 0){
                czeros ++;
            }
            if(arr[(i - window)] == 0){
                czeros--;
            }

            ans = Math.min(ans, czeros);
        }
        return ans;


    }
}

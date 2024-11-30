package Arrays_String_FINAL;

// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
public class MaximumChunksToMakeArraySorted2 {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4};

        int ans = maxChunksToSorted(arr);
        System.out.println(ans);
    }

    private static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] rmin = new int[n + 1];
        rmin[n] = Integer.MAX_VALUE;


        for(int i=n-1; i>=0; i--){
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }

        int count = 0;
        int lmax = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            lmax = Math.max(lmax, arr[i]);

            if(lmax <= rmin[i+1]) count++;
        }
        return count;
    }
}

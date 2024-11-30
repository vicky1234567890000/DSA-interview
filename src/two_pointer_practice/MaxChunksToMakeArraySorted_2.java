package two_pointer_practice;

// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
public class MaxChunksToMakeArraySorted_2 {
    public static void main(String[] args) {
        int[] arr = {30, 10, 20, 40, 60, 50, 75, 70};
        int n = arr.length;
        int[] rmin = new int[n + 1];
        rmin[n] = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--) {
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }
        int lmax = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<n; i++) {
            lmax = Math.max(arr[i], lmax);

            if(lmax <= rmin[i+1]) count++;
        }
        System.out.println(count);

    }
}

package two_pointer_practice;

public class PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        int[] arr = {5,0,3,8,6};
        int n = arr.length;
        int[] rmin = new int[n + 1];
        rmin[n] = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--) {
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }

        int lmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);

            if(lmax <= rmin[i+1]) {
                ans = i;
                break;
            }

        }

        System.out.println(ans + 1);
    }
}

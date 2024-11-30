package two_pointer_practice;

public class PartitionArrayIntoDisjointIntervals_1 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,6,12};
        int partition = partitionDisjoint(arr);
        System.out.println(partition);
    }

    private static int partitionDisjoint(int[] arr) {
        int n = arr.length;
        int[] rmin = new int[n+1];

        rmin[n] = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }

        int lmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            lmax = Math.max(arr[i], lmax);

            if(lmax <= rmin[i+1]){
                ans = i;
                break;
            }
        }
        return ans+1;
    }
}

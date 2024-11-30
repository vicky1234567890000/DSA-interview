package Arrays_String_FINAL;

public class
PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,6,12};
        int partitions = partitionArrayIntoDisjointIntervals(arr);
        System.out.println(partitions);
    }

    private static int partitionArrayIntoDisjointIntervals(int[] arr) {




        int n = arr.length;
        int[] rmin = new int[arr.length + 1];
        rmin[n] = Integer.MAX_VALUE;

        for(int i = n-1; i>=0; i--){
            rmin[i] = Math.min(arr[i], rmin[i+1]);
        }



        int lmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<n; i++){
            lmax = Math.max(lmax, arr[i]);

            if(lmax <= rmin[i+1]) {
                ans = i;
                break;
            }
        }
        return ans + 1;
    }
}

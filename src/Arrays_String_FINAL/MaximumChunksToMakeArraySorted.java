package Arrays_String_FINAL;

// https://www.geeksforgeeks.org/problems/maximum-number-of-partitions-that-can-be-sorted-individually-to-make-sorted2926/1
public class MaximumChunksToMakeArraySorted {
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 3};
        int count = maxPartitions(arr, arr.length);
        System.out.println(count);
    }

    private static int maxPartitions(int[] arr, int n) {
        int max = 0;

        int chunk_count = 0;

        for(int i=0; i<arr.length; i++){

            max = Math.max(max, arr[i]);
            if(i==max) {
                chunk_count ++;
            }

        }
        return chunk_count;
    }
}

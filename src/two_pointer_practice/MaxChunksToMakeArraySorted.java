package two_pointer_practice;

// https://leetcode.com/problems/max-chunks-to-make-sorted/description/
public class MaxChunksToMakeArraySorted {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,0};
        int max = Integer.MIN_VALUE;
        int chunk_count = 0;

        for(int i=0; i< arr.length; i++) {
            max = Math.max(arr[i], max);

            if(max == i) chunk_count++;
        }
        System.out.println(chunk_count);
    }
}

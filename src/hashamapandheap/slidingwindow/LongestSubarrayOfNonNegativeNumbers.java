package hashamapandheap.slidingwindow;

// https://practice.geeksforgeeks.org/problems/length-of-longest-subarray0440/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
public class LongestSubarrayOfNonNegativeNumbers {
    public static void main(String[] args) {

        int A[] = {2, 3, 4, -1, -2, 1, 5, 6, 3};

        int maxLen = 0;

        for(int i=0; i<A.length; i++){
            int len = 0;
            while(i < A.length && A[i] > 0){
                len++;
                i++;
            }

            maxLen = Math.max(maxLen,len);
        }
        System.out.println(maxLen);
    }
}

package hashamapandheap.slidingwindow;

public class LongestIncreasingSubarray {
    public static void main(String[] args) {

        int a[] = {5, 6, 3, 5, 7, 8, 9, 1, 2};

        int len = 1;
        int maxLen = 1;
        for(int i=1; i<a.length; i++){

            if(a[i] > a[i-1]){
                len++;
            }else{
                len = 1;
            }
            maxLen = Math.max(len,maxLen);
        }
        System.out.println(maxLen);
    }
}

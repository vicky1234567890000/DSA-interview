package hashamapandheap.slidingwindow.irritating_problem;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {

        int[] arr = {1,1,1,0,0,0,1,1,1,1,0 };
        int zeroCount = 0;
        int k = 2;
        int maxLen = 0;
       int j = -1;
        for(int i=0; i<arr.length; i++){

            if(arr[i] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
              j++;
              if(arr[j] == 0){
                  zeroCount--;
              }
            }

            int len = i - j;


            maxLen = Math.max(len, maxLen);

        }
        System.out.println(maxLen);
    }
}

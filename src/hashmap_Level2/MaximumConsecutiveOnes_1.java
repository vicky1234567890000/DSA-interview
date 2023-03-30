package hashmap_Level2;

public class MaximumConsecutiveOnes_1 {

    public static void main(String[] args){
        int[] arr = {1,1,0,1,0,0,1,1,0,1,0,1,1};
        int ans = 0;
        int j = -1;
        int count = 0;
        int k = 2;

        for(int i=0; i<arr.length; i++){

            if(arr[i] == 0){
                count++;
            }

            while(count > k){
                j++;
                if(arr[j] == 0)
                    count--;
            }

            int len = i - j;
            if(len > ans){
                ans = len;
            }

        }
        System.out.println(ans);
    }
}

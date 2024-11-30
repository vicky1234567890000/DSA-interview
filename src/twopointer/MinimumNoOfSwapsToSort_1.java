package twopointer;

public class MinimumNoOfSwapsToSort_1 {

    public static void main(String[] args){
        int[] arr = {4,4,2,3};

        int ans = countSwaps(arr);
        System.out.println(ans);
    }

    private static int countSwaps(int[] arr) {

        int count=0;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

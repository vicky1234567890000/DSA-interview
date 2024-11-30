public class ClosestElement {
    public static void main(String[] args) {
        int[] arr = {2,5,10,-4,-7,88,43};
        int ele = -100;

        int ans =  closestElement(arr, ele);
        System.out.println(ans);
    }

    private static int closestElement(int[] arr, int ele) {

        int minDiff = Integer.MAX_VALUE;
        int ans = arr[0];

        for(int i=0; i<arr.length; i++){

            int diff = Math.abs(ele - arr[i]);
            if(diff < minDiff){
                minDiff = diff;
                ans = arr[i];
            }


        }
        return ans;

    }
}

package Arrays_String_FINAL;

// https://www.geeksforgeeks.org/problems/maximum-triplet-product--170647/1
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {

        Long[] arr = {-3L, -5L, 1L, 0L, 8L, 3L, -2L};
        Long ans = maxTripletProduct(arr);
        System.out.println(ans);
    }

    private static Long maxTripletProduct(Long[] arr) {


        Long min1 = Long.MAX_VALUE;
        Long min2 = Long.MAX_VALUE;

        Long max1 = Long.MIN_VALUE;
        Long max2 = Long.MIN_VALUE;
        Long max3 = Long.MIN_VALUE;

        for(int i =0; i< arr.length; i++){
            if(arr[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if(arr[i] > max2){
                max3 = max2;
                max2 = arr[i];

            } else if(arr[i] > max3){
                max3 = arr[i];
            }

            if(arr[i] < min1){
                min2 = min1;
                min1 = arr[i];
            } else if(arr[i] < min2){
                min2 = arr[i];
            }


        }

        return Math.max(min1 * min2 * max1 , max1 * max2 * max3);
    }
}

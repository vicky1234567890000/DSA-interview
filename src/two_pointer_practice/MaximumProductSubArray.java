package two_pointer_practice;

public class MaximumProductSubArray {
    public static void main(String[] args) {

        int[] arr = {2,3,-2,-5,6,-1, 4};

        int ans = maxProductSubArray(arr);
        System.out.println(ans);
    }

    private static int maxProductSubArray(int[] arr) {

        int ans = arr[0];

        int leftProduct = 1;
        int rightProduct = 1;

        for(int i=0; i<arr.length; i++){

            leftProduct = leftProduct==0 ? 1 : leftProduct;
            rightProduct = rightProduct==0 ? 1 : rightProduct;


            leftProduct = leftProduct * arr[i];
            rightProduct = rightProduct * arr[arr.length - 1- i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));

        }
        return ans;
    }
}

package Arrays_String_FINAL;

// https://www.geeksforgeeks.org/problems/container-with-most-water0535/1
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] A = {1,5,4,3};

        long max = maxArea(A, A.length);
        System.out.println(max);
    }

    private static long maxArea(int[] A, int len) {
        long ans = 0;

        int i=0;
        int j = len -1;

        while(i < j){



            long area = (long) (j - i) * Math.min(A[i],A[j]);
            ans = Math.max(ans,  area);
            if(A[i] < A[j]) i++;
            else j--;


        }
        return ans;
    }

}

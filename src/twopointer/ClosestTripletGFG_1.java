package twopointer;

public class ClosestTripletGFG_1 {

    public static void main(String[] args) {
        int[] A = {1, 4, 10};
        int[] B = {2, 15, 20};
        int[] C = {10, 12};

        int P = A.length;
        int Q = B.length;
        int R = C.length;

        // Function calling
        int min = findClosest(P, Q, R, A, B, C);
        System.out.println(min);
    }

    private static int findClosest(int P, int Q, int R, int[] A, int[] B, int[] C) {

        int min = Integer.MAX_VALUE;
        int i=0,j=0,k=0;

        while(i<P && j<Q && k<R){

            int minimum = Math.min(A[i],Math.min(B[j],C[k]));
            int maximum = Math.max(A[i],Math.max(B[j],C[k]));
            int diff = maximum - minimum;

            min = Math.min(diff,min);
            if(A[i]==minimum) i++;
            else if(B[j]==minimum) j++;
            else k++;
        }

        return min;
    }
}

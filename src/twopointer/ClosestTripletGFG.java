package twopointer;

//Given three sorted arrays A[] of size P,
// B[] of size Q and C[] of size R.
// Find a number X such that when  3 elements i, j and k are chosen from A, B and C respectively,
// then X=max(abs(A[i] – B[j]), abs(B[j] – C[k]), abs(C[k] – A[i])) is minimized.
// Here abs() indicates absolute value.
//
//        Example 1:
//
//        Input:
//        P=3
//        A[] = {1, 4, 10}
//        Q=3
//        B[] = {2, 15, 20}
//        R=2
//        C[] = {10, 12}
//        Output:
//        5
//        Explanation:
//        We take 10 from A, 15 from B and
//        10 from C, so,
//        X=max(abs(10-15),abs(15-12),abs(10-10))
//        which gives X=18
//        Example 2:
//
//        Input:
//        P=3
//        A[] = {20, 24, 100}
//        Q=5
//        B[] = {2, 19, 22, 79, 800}
//        R=5
//        C[] = {10, 12, 23, 24, 119}
//        Output:
//        2
//        Explanation:
//        We take 24 from A,22 from B and 24 from C.X
//        =max(abs(24-22),max(abs(24-22),abs(24-24)))
//        which is 2.
public class ClosestTripletGFG {
    public static void main(String[] args){
        int P=3;
        int Q=3;
        int R=2;
        int[] A = {1, 4, 10};
        int[] B = {2, 15, 20};
        int[] C = {10, 12};

        int ans = findClosest(P,Q,R,A,B,C);
        System.out.println(ans);

    }

    private static int findClosest(int P, int Q, int R, int[] A, int[] B, int[] C) {

        int min = Integer.MAX_VALUE;

        for(int i=0;i<P;i++){
            for(int j=0;j<Q;j++){
                for(int k=0;k<R;k++){
                    int ab = Math.abs(A[i]-B[j]);
                    int bc = Math.abs(B[j]-C[k]);
                    int ca = Math.abs(C[k]-A[i]);
                    int max = 0;
                    if(ab > bc && ab > ca){
                        max = ab;
                    }else max = Math.max(bc, ca);

                    min = Math.min(max,min);
                }
            }

        }
        return min;
    }
}

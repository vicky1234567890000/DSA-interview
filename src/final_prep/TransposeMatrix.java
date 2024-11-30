package final_prep;

import java.util.Arrays;

public class TransposeMatrix {




    public static void main(String[] args) {
       int[][] arr = {{1,2,3},{4,5,6}};
       int[][] transpose = transposeOfMatrix(arr);

       for(int[] x : transpose)
        System.out.println(Arrays.toString(x));
    }

    private static int[][] transposeOfMatrix(int[][] arr) {

        int r = arr.length;
        int c = arr[0].length;

        int[][] ans = new int[c][r];

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){

                ans[i][j] = arr[j][i];
            }
        }
        return ans;
    }
}

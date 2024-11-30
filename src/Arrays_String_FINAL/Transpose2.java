package Arrays_String_FINAL;

import java.util.Arrays;

public class Transpose2 {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6}};

       int[][] ans = transpose(matrix);

       for(int[] a : ans){
           System.out.println(Arrays.toString(a));
       }

    }

    private static int[][] transpose(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}

package final_prep;

import java.util.Arrays;

public class SetMatricesZero {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        int[][] ans = setMatricesZero(matrix);

        for(int[] a : ans){
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] setMatricesZero(int[][] matrix) {

        boolean first_row = false;
        boolean first_col = false;


        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){

                if(matrix[i][j] == 0){
                    if(i==0) first_row = true;
                    if(j==0) first_col = true;

                    matrix[0][j] = 0;

                    matrix[i][0] = 0;
                }
            }
        }


        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){

                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(first_row){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(first_col){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }
}

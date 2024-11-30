package Arrays_String_FINAL;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotateBy90CW(matrix, matrix.length);

        int[][] matrix1 = matrix;

        rotateBy90ACW(matrix1, matrix1.length);

        System.out.println("clockwise");
        System.out.println();
        for(int[] a : matrix){
            System.out.println(Arrays.toString(a));
        }

        System.out.println();
        System.out.println("anti-clockwise");
        for(int[] a : matrix1){
            System.out.println(Arrays.toString(a));
        }
    }

    private static void rotateBy90ACW(int[][] matrix, int n) {

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int c = 0;

        while(c < n){

            int i=0;
            int j=n-1;

            while(i < j){

                int temp = matrix[i][c];
                matrix[i][c] = matrix[j][c];
                matrix[j][c] = temp;
                i++;
                j--;
            }
            c++;
        }
    }

    private static void rotateBy90CW(int[][] matrix, int n) {

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int r= 0;

        while(r < n){

            int i=0;
            int j=n-1;

            while(i < j){
                int temp = matrix[r][i];
                matrix[r][i] = matrix[r][j];
                matrix[r][j] = temp;
                i++;
                j--;
            }
            r++;
        }
    }
}

package Arrays_String_FINAL;

import java.util.Arrays;

public class Transpose1 {
    public static void main(String[] args) {

        int[][] mat = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};

        transpose(mat.length, mat);

        for(int[] a : mat){
            System.out.print(Arrays.toString(a) + " , ");
        }
    }

    public static void transpose(int n,int arr[][])
    {

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }


    }
}

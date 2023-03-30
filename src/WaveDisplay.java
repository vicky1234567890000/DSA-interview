import java.util.Scanner;

public class WaveDisplay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Input matrix");
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("output matrix");
        for(int j=0; j< matrix[0].length; j++) {
            if(j % 2 ==0){
                for(int i=0; i<matrix.length; i++){
                    System.out.print(matrix[i][j]+" ");
                }
            }else {
                for(int i=matrix.length-1; i >= 0; i--){
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        }


    }
}
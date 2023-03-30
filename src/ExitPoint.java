import java.util.Scanner;

public class ExitPoint {

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

        int dir = 0, i=0, j=0;

        while(true) {

            dir = (dir + matrix[i][j]) % 4;
            if(dir == 0) j++;
            else if(dir == 1) i++;
            else if(dir == 2) j--;
            else if (dir == 3) i--;

            if(i < 0) {
                i++;
                break;
            }else if(j < 0) {
                j++;
                break;
            }else if(i == matrix.length) {
                i--;
                break;
            }else if(j == matrix[0].length) {
                j--;
                break;
            }
        }

        System.out.print("["+i+","+j+"]");
    }

}

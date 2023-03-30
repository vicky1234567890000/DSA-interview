import java.util.Scanner;

public class SpiralDisplay {

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

        int minr = 0,minc = 0,maxr = r-1,maxc = c-1;

        int cnt=0,tne = r*c;

        while(cnt < tne) {
            //left wall
            for(int i=minr,j=minc;i<=maxr && cnt < tne;i++) {
                System.out.print(matrix[i][j]+" ");
                cnt++;
            }
            minc++;
            //bottom wall
            for(int i=maxr,j=minc;j<=maxc && cnt < tne;j++) {
                System.out.print(matrix[i][j]+" ");
                cnt++;
            }
            maxr--;
            //right wall
            for(int i=maxr,j=maxc;i>=minr && cnt < tne;i--) {
                System.out.print(matrix[i][j]+" ");
                cnt++;
            }
            maxc--;
            //top wall
            for(int i=minr,j=maxc;j>=minc && cnt < tne;j--) {
                System.out.print(matrix[i][j]+" ");
                cnt++;
            }
            minr++;
        }
    }
}

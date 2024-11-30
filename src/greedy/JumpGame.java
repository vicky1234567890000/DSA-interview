package greedy;

public class JumpGame {


    public static void main(String[] args){
        int[] arr = {2,1,0,3};
        int bit = canReach(arr,arr.length);
        System.out.println(bit);
    }

    private static int canReach(int[] A, int N) {

        if(A.length==1 && A[0] >= 0){
            return 1;
        }
        int pos=0;
        int des=0;
        int jump=0;
        for(int i=0;i<N;i++){

            des = Math.max(des,A[i]+i);

            if(pos==i){
                if(A[i]==0 && pos==des){
                    return 0;
                }
                pos=des;
                jump++;

            }
        }
        if(jump > 0){
            return 1;
        }
        return 0;

    }
}

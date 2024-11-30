package greedy;

// Solution link => https://youtu.be/wLPdkLM_BWo
public class MinimumNumberOfJumpsToReachEnd {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 0, 2, 3};
        int[] arr1 = {2,1,0,3};
        int[] arr3 = {3,4,5,2,3,1,4,2};
        int min = minJumps(arr3);
        System.out.println(min);

    }

    private static int minJumps(int[] arr) {

        int des = 0;
        int pos = 0;
        int jump = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            des = Math.max(des, arr[i] + i);

            if (pos == i) {
                if(arr[i]==0 && pos==des){
                    return -1;
                }
                pos = des;
                jump++;
            }
        }

        return jump;
    }
}

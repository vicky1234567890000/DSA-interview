package greedy;

import java.util.Arrays;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class JobSequencingProblem {
    public static void main(String[] args) {

        Job[] arr = new Job[4];
        arr[0] = new Job(1,4,20);
        arr[1] = new Job(2,1,10);
        arr[2] = new Job(3,2,40);
        arr[3] = new Job(4,1,30);

        int[] ans = JobScheduling(arr,arr.length);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] JobScheduling(Job[] arr, int n) {

        Arrays.sort(arr,(x,y)-> y.profit-x.profit);

        int maxDeadline=0;
        for(int i=0;i<n;i++){
            maxDeadline = Math.max(arr[i].deadline,maxDeadline);
        }

        int[] res = new int[maxDeadline+1];
        int maxProfit=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].deadline; j>0; j--){
                if(res[j]==0){
                   res[j]=arr[i].id;
                   count++;
                   maxProfit += arr[i].profit;
                   break;
                }
            }
        }

        int m = 0;
        for(int i=1;i<res.length;i++){
            if(res[i] != 0){
                m++;
            }
        }
        int[] ans = new int[m];
        int j=0;
        for(int i=1;i<res.length;i++){
            if (j<m) {
                if (res[i] != 0) {
                    ans[j] = res[i];
                    j++;
                }
            }
        }

        return ans;

    }


}

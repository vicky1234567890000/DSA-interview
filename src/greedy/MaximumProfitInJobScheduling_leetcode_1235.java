package greedy;

import java.util.Arrays;
import java.util.TreeMap;

class Jobs {
    int startTime;
    int endTime;
    int profit;

    Jobs(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

}
public class MaximumProfitInJobScheduling_leetcode_1235 {

    public static void main(String[] args) {
       int[] startTime = {1,2,3,3};
       int[] endTime = {3,4,5,6};
       int[] profit = {50,10,40,70};

        int maxProfit = jobScheduling(startTime,endTime,profit);
        System.out.println(maxProfit);
    }

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        Jobs[] jobs = new Jobs[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Jobs(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,(x, y)->x.endTime-y.endTime);

        TreeMap<Integer,Integer> tmap = new TreeMap<>(); // key => endTime , value => profit till time
        int ans = 0;

        for(Jobs job : jobs){
            //Integer profitTillStartTime = tmap.getOrDefault(tmap.floorKey(job.startTime),0);
            Integer entryTillStartTime = tmap.floorKey(job.startTime);
            Integer maxProfitTillStartTime = (entryTillStartTime == null)?0:tmap.get(entryTillStartTime);
            ans = Math.max(ans,maxProfitTillStartTime + job.profit);
            tmap.put(job.endTime,ans);
        }

        return ans;
    }


}

package greedy;

import java.util.Arrays;

class Activity implements Comparable<Activity> {

    Integer start;
    Integer end;

    public int compareTo(Activity a) {
        return this.end.compareTo(a.end);
    }

    public void setStart(Integer I) {
        this.start = I;
    }

    public void setEnd(Integer J) {
        this.end = J;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class ActivitySelectionProblem {

    public static void main(String[] args) {
        int[] start = {1, 3, 2, 5};
        int[] end = {2, 4, 3, 6};
        int n = start.length;

        int ans = activitySelection(start, end, n);

        System.out.println(ans);
    }

    private static int activitySelection(int[] start, int[] end, int n) {

        Activity[] actArr = new Activity[n];
        for (int i = 0; i < n; i++) {
            Activity a = new Activity();
            a.setStart(start[i]);
            a.setEnd(end[i]);
            actArr[i] = a;
        }
        Arrays.sort(actArr);
        //System.out.println(Arrays.toString(actArr));
        int count = 1;
        int prevEnd=actArr[0].end;

        for(int i=1;i<n;i++){
            if(actArr[i].start > prevEnd){
                count++;
                prevEnd=actArr[i].end;
            }
        }

        return count;
    }
}

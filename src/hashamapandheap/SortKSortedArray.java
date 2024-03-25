package hashamapandheap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {

        int[] arr = {2,3,1,4,6,7,5,8,9};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        while(i < k+1){
            pq.add(arr[i]);
            i++;
        }
        List<Integer> ans = new ArrayList<>();
        while(i < arr.length){
            ans.add(pq.remove());
            pq.add(arr[i]);
            i++;
        }

        while(pq.size() > 0){
            ans.add(pq.remove());
        }
        System.out.println(ans);
    }
}

package hashamapandheap;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {

        int[] arr = {4,2,7,1,3};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while(i < k){
            pq.add(arr[i]);
            i++;
        }

        while(i < arr.length){
            if(pq.peek() != null && arr[i] >= pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
            i++;
        }

        while(pq.size() > 0){
            System.out.print(pq.remove() + " ");
        }
    }
}

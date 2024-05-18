package codingAndConcept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeapExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(10);
        pq.add(20);
        pq.add(16);
        pq.add(4);
        pq.add(1);

        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        Integer[] arr = {17,3,5,10};
        Arrays.sort(arr, (a,b) -> b-a);
        System.out.println(Arrays.toString(arr));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortKSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        List<Integer> li = List.of(2,3,1,4,6,7,5,8,9);

        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<=k;i++){
            pq.add(li.get(i));
        }
        for(int i=k+1;i<li.size();i++){
            res.add(pq.remove());
            pq.add(li.get(i));
        }
        while(pq.size() > 0){
            res.add(pq.remove());
        }
        System.out.println(res);
    }
}

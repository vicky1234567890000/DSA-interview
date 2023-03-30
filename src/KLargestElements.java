import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<Integer> li = List.of(20,3,1,14,6,15,5,8,9);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(li.get(i));
        }
        for(int i=k;i<li.size();i++){
            if(li.get(i) > pq.peek()) {
                pq.remove();
                pq.add(li.get(i));
            }
        }
        while(pq.size() > 0){
            System.out.print(pq.remove()+" ");
        }
    }

}

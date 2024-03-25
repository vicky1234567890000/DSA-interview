package hashamapandheap;

import java.util.*;
import java.util.stream.Collectors;

public class MergeKSortedList {
    private static class Pair{
        int li;
        int di;
        int val;

        Pair(int li,int di,int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "li=" + li +
                    ", di=" + di +
                    ", val=" + val +
                    '}';
        }
    }
    public static void main(String[] args) {

        List<List<Integer>> ll = List.of(List.of(2,3,4),List.of(1,5,5,6),List.of(0,1,1,7));

        List<Integer> collect = ll.stream().flatMap(Collection::stream).sorted().collect(Collectors.toList());
        System.out.println(collect);
        int[][] a = { { 2,3,4 }, { 1,5,5,6 }, { 0,1,1,7 }, };

        List<Integer> collect1 = Arrays.stream(a)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int[] res = collect1.stream().mapToInt(i->i).toArray();

        System.out.println(collect1);

        Integer[][] b = { { 2,3,4 }, { 1,5,5,6 }, { 0,1,1,7 }, };
        List<List<Integer>> arr = Arrays.stream(b)
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<Integer> ans = mergeKSortedList(ll);
        System.out.println(ans);
    }

    private static List<Integer> mergeKSortedList(List<List<Integer>> ll) {

        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Pair> pq1 = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(p -> p.val)));
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
        for(int i=0; i<ll.size(); i++){
            pq.add(new Pair(i,0,ll.get(i).get(0)));
        }

        while(pq.size() > 0) {
            Pair peek = pq.remove();
            ans.add(peek.val);
            peek.di++;

            if (peek.di < ll.get(peek.li).size()) {
                pq.add(new Pair(peek.li, peek.di, ll.get(peek.li).get(peek.di)));
            }
        }
        return ans;


    }
}

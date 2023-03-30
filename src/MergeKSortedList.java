import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {

        List<List<Integer>> lists = List.of(List.of(10, 20, 30, 40),
                List.of(5, 9, 12, 18, 32),
                List.of(11, 15, 17),
                List.of(2, 6, 10, 14));

        List<Integer> res = mergeKSortedListFunc(lists);

        System.out.println(res);
    }

    private static List<Integer> mergeKSortedListFunc(List<List<Integer>> lists) {

        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            Pair p = new Pair(i,0,lists.get(i).get(0));
            pq.add(p);
        }

        while(pq.size() > 0){
            Pair p = pq.remove();
            res.add(p.val);
            p.di++;

            if(p.di < lists.get(p.li).size()){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return res;
    }

    static class Pair implements Comparable<Pair> {

        int li;
        int di;
        int val;

        public Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public Pair() {
        }

        public int getLi() {
            return li;
        }

        public int getDi() {
            return di;
        }

        public int getVal() {
            return val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}




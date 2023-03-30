import java.util.HashMap;
import java.util.List;

public class LongestConsecutiveSequence {

    public static void main(String[] args){
        List<Integer> list = List.of(10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2);
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (Integer integer : list) {
            map.put(integer, true);
        }
        for (Integer integer : list) {
            if (map.containsKey(integer - 1)) {
                map.put(integer, false);
            }
        }
        int msp = 0;
        int ml = 0;
        for (Integer val : list){
            if(map.get(val)){
                int cl = 1;
                int csp = val;

                while(map.containsKey(csp + cl)){
                    cl++;
                }
                if(cl > ml){

                    ml = cl;
                    msp = csp;
                }
            }
        }
        for(int i=0;i<ml;i++){
            System.out.print(msp+i+" ");
        }
        //System.out.println(ml);
    }
}

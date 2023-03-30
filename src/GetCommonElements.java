import java.util.HashMap;
import java.util.List;

public class GetCommonElements {

    public static void main(String[] args){
        List<Integer> l1 = List.of(1, 1, 1, 2, 2, 4, 5);
        List<Integer> l2 = List.of(1,1,2,3,5);

        HashMap<Integer,Integer> fmap = new HashMap<>();
        for(Integer val : l1){

           fmap.put(val,fmap.getOrDefault(val,0)+1);
        }

        for(Integer val : l2){
            if(fmap.containsKey(val) && fmap.get(val) > 0){
               System.out.print(val+" ");
                fmap.put(val,fmap.getOrDefault(val,0)-1);
            }
        }

        //System.out.println(fmap);
    }
}

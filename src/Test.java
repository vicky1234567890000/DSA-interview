/*
array[]={1,3,-5,7,8,20,-40,6};
The pair whose sum is closest to zero
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        int[] arr = {1,3,-5,7,8,20,-40,6};
//
//        Arrays.sort(arr);
//
//        int closestSum = arr[0] + arr[arr.length-1];
//        int tar = 0;
//        int i = 0;
//        int j=arr.length - 1;
//        int x = -1;
//        int y = -1;
//        while(i < j){
//
//            int currSum = arr[i] + arr[j];
//
//            if(Math.abs(currSum - tar) < Math.abs(closestSum - tar)){
//                closestSum = currSum;
//                x = arr[i];
//                y = arr[j];
//            }
//
//            if(currSum < tar){
//                i++;
//            }
//            else{
//                j--;
//            }
//        }
//
//        System.out.println(x + "  " + y);

        List<String> list = List.of("aa", "bb", "aa", "cc","abc","xyz");

        ConcurrentHashMap<String, Long> fmap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, ConcurrentHashMap::new
                ));

        List<String> ans = new ArrayList<>();
        for(String s : fmap.keySet()){
            if(fmap.get(s) != null){
                ans.add(s);
                fmap.remove(s);
            }
        }
        System.out.println(ans);

    }


}

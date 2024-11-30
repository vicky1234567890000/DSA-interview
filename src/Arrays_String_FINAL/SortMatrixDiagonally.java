package Arrays_String_FINAL;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/sort-the-matrix-diagonally/description/
// refer codeStoryWithMIK video on Youtube
public class SortMatrixDiagonally {
    public static void main(String[] args) {
        int[][] arr = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        Map<Integer, List<Integer>> map = new HashMap<>();
        int x = arr.length;
        int y = arr[0].length;

        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
               if(map.get(i-j) != null){

                   List<Integer> list = map.get(i - j);
                   list.add(arr[i][j]);
                   map.put(i-j,list);
               } else{

                   List<Integer> list = new ArrayList<>();
                   list.add(arr[i][j]);
                   map.put(i-j,list);
               }
            }
        }

        Map<Integer, List<Integer>>   sortedMap = map.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue()
                        .stream().sorted()
                        .collect(Collectors.toList())

        ));








        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                arr[i][j] = sortedMap.get(i-j).remove(0);
            }
        }


        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}

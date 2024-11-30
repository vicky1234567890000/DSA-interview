package hashmap_Level2;

import java.util.HashMap;

public class FruitsInBasket {

    public static void main(String[] args){

        int[] arr = {1,2,2,2,3,3};
        int i=0;
        int j=0;
        int max=1;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(j < arr.length){
            if(map.size() <= 2){
                map.put(arr[j],j++);
            }

            if(map.size() > 2){
                int min = arr.length-1;

                for(int value : map.values()){
                    min = Math.min(min,value);
                }
                i = min+1;
                map.remove(arr[min]);
            }
            max = Math.max(max,j - i);
            System.out.print(max);
        }

        System.out.println(max);
    }
}

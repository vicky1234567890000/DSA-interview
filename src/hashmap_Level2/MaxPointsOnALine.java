package hashmap_Level2;

import java.util.HashMap;

public class MaxPointsOnALine {
    public static void main(String[] args){

        int[][] points = {{1,1},{2,2},{3,3},{4,5},{5,6},{9,11},{6,7},{7,8}};

        int max = maxPoints(points);

        System.out.println(max);
    }

    private static int maxPoints(int[][] points) {

        int max=0;
        for(int[] point1 : points){
            HashMap<Double,Integer> map = new HashMap<>();
            for(int[] point2 : points){
                if(point1 == point2) continue;

                double slope = 0.0;
                if(point2[0] == point1[0]){
                    slope = Double.MAX_VALUE;
                }else{
                    slope = (double)(point2[1]-point1[1])/(point2[0] - point1[0]);
                }
                map.put(slope,map.getOrDefault(slope,0)+1);
                if(map.get(slope) > max){
                    max = map.get(slope);
                }
            }
        }

        return max+1;
    }
}

package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

//    public int compareTo(Item i1){
//        double res = i1.value/(double)i1.weight - this.value/(double)this.weight;
//        if(res > 0 && res < 1){
//            return 1;
//        }
//        return (int)res;
//    }

}
public class FractionalKnapsack {

    public static void main(String[] args){
        int[] W = {1,3,2};
        int[] V = {10,10,10};
        int n = W.length;
        int w=2;
        Item[] arr = new Item[W.length];

        for(int i=0;i<n;i++){
            arr[i] = new Item(V[i],W[i]);
        }
        double ans = fractionalKnapsack(w,arr,n);
        System.out.println(ans);
    }

    public static double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        double ans = 0.0;
        int currW = 0;

        Arrays.sort(arr, (x, y) -> {
            double res = y.value/(double)y.weight - x.value/(double)x.weight;
            return ((res>0 && res<1) ? 1 : (int)res);
        });

        Integer[] num = {3,4,1,2};
       Arrays.sort(num, Collections.reverseOrder());
       System.out.println(Arrays.toString(num));
        //Arrays.stream(arr).sorted(Comparator.comparing((i1,i2) -> i1.value-i2.value));

//        int[] num = {3,4,1,2};
//        Arrays.stream(num).sorted();


        System.out.println(Arrays.toString(arr));

        for(int i=0;i<n;i++){
            if(arr[i].weight + currW <= W){
                ans += arr[i].value;
                currW += arr[i].weight;
            }else{
                int remainW = W - currW;
                ans += (arr[i].value/(double)arr[i].weight) * (double)remainW;
                break;
            }
        }
        return ans;
    }

}

package two_pointer_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThressSumUnique {
    public static void main(String[] args) {
        int[] arr = {-2,1,1,3,-5,2,0};
        List<List<Integer>> ans = findTriplets(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> findTriplets(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<arr.length -2; i++){

            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            int l = i+1;
            int r = arr.length-1;

            while(l < r){
                int sum = arr[l] + arr[r] + arr[i];
                if(sum == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[l]);
                    list.add(arr[r]);
                    list.add(arr[i]);
                    ans.add(list);
                    l++;
                    r--;

                    while(l < r && arr[l] == arr[l-1]) l++;
                    while(l < r && arr[r] == arr[r+1]) r--;
                }


                else if(sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }
}


package twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/three-equal-parts/submissions/1214402758/
public class ThreeEqualParts {
    public static void main(String[] args) {
        int[] arr = {0,0,0};
        int[] res = threeEqualParts(arr);
        System.out.println(Arrays.toString(res));

    }

    private static int[] threeEqualParts(int[] arr) {
        int noOf1s = 0;
        for(int x : arr){
            noOf1s += x;
        }
        if(noOf1s == 0) return new int[]{0,2};
        int[] defRes = new int[]{-1,-1};
        if(noOf1s % 3 != 0) return defRes;
        int noOf1sInEachPart = noOf1s/3;

        noOf1s = 0;
        int posOfOneInPart1 = -1;
        int posOfOneInPart2 = -1;
        int posOfOneInPart3 = -1;

        for(int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                noOf1s++;

                if (noOf1s == noOf1sInEachPart + 1) {
                    posOfOneInPart2 = i;
                } else if (noOf1s == 2 * noOf1sInEachPart + 1) {
                    posOfOneInPart3 = i;
                } else if (noOf1s == 1) {
                    posOfOneInPart1 = i;
                }
            }
        }

        while(posOfOneInPart3 < arr.length){
            if(arr[posOfOneInPart1] == arr[posOfOneInPart2] &&
            arr[posOfOneInPart2] == arr[posOfOneInPart3]){
                posOfOneInPart3++;
                posOfOneInPart1++;
                posOfOneInPart2++;
            }else{
                return defRes;
            }
        }

        return new int[]{posOfOneInPart1-1, posOfOneInPart2};

    }

}

package two_pointer_practice;

import java.util.Arrays;

// https://leetcode.com/problems/three-equal-parts/description/
public class ThreeEqualParts {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int[] ans = threeEqualParts(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] threeEqualParts(int[] arr) {

        int onesCount = 0;
        for(int x : arr) {
            onesCount += x;
        }

        if(onesCount == 0) {
            return new int[]{0, 2};
        }

        if(onesCount % 3 != 0){
            return new int[]{-1, -1};
        }

        int indexOfOneInPart0 = -1;
        int indexOfOneInPart1 = -1;
        int indexOfOneInPart2 = -1;
        int noOfOnesInEachPart = onesCount/3;
        onesCount = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                onesCount++;
                if (onesCount == 1) {
                    indexOfOneInPart0 = i;
                } else if (onesCount == noOfOnesInEachPart + 1) {
                    indexOfOneInPart1 = i;
                } else if (onesCount == 2 * noOfOnesInEachPart + 1) {
                    indexOfOneInPart2 = i;
                }
            }
        }

        while(indexOfOneInPart2 < arr.length) {

            if(arr[indexOfOneInPart2] == arr[indexOfOneInPart0] && arr[indexOfOneInPart2] == arr[indexOfOneInPart1]) {
                indexOfOneInPart2++;
                indexOfOneInPart0++;
                indexOfOneInPart1++;
            } else {
                return new int[]{-1, -1};
            }
        }

        return new int[]{indexOfOneInPart0 -1, indexOfOneInPart1};
    }
}

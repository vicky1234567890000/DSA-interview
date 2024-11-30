package twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given an array A[ ] of positive integers of size N,
// where each value represents the number of chocolates in a packet.
// Each packet can have a variable number of chocolates.
// There are M students, the task is to distribute chocolate packets among M students such that :
//        1. Each student gets exactly one packet.
//        2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
//
//        Example 1:
//
//        Input:
//        N = 8, M = 5
//        A = {3, 4, 1, 9, 56, 7, 9, 12}
//        Output: 6
//        Explanation: The minimum difference between
//        maximum chocolates and minimum chocolates
//        is 9 - 3 = 6 by choosing following M packets :
//        {3, 4, 9, 7, 9}.
public class ChocolateDistributionProblem {
    public static void main(String[] args) {

        ArrayList<Integer> a = (ArrayList<Integer>) List.of(3, 4, 1, 9, 56, 7, 9, 12);
        long minDiff = findMinDiff(a, a.size(), 5);
        System.out.println(minDiff);

    }

    private static long findMinDiff(ArrayList<Integer> a, int n, int m) {

        long min = Long.MAX_VALUE;
        Collections.sort(a);
        for(int i=0;i<(n-m+1);i++){
            min = Math.min((long)(a.get(i+m-1)-a.get(i)),min);
        }
        return min;
    }
}

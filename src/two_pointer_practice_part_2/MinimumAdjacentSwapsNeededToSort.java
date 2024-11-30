package two_pointer_practice_part_2;

// https://www.geeksforgeeks.org/problems/minimum-number-of-swaps-needed2136/1

/*
Given an array arr[] of size N of non negative integers.
 We can perform a swap operation on any two adjacent elements in the array.
 The task is to find the minimum number of swaps needed to sort the array in non - decreasing order.
 */

import java.util.*;

/*
Input:
N = 4
arr[] = {4, 4, 2, 3}
Output: 4
Explanation: (4,4,2,3) -> (4,2,4,3) ->
(4,2,3,4) -> (2,4,3,4) -> (2,3,4,4,).
Hence we need a total of 4 swap to
sort it in increasing order.
 */
public class MinimumAdjacentSwapsNeededToSort {
    public static void main(String[] args) {

        int N = 4;
        int[] arr = {4, 4, 2, 3};
        int result = minSwapsToSort(arr, N);
        System.out.println(result);
    }

    private static int minSwapsToSort(int[] arr, int N) {
        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);

        // Create a map to store the original indices of the elements
        Map<Integer, Queue<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], new LinkedList<>());
            }
            indexMap.get(arr[i]).offer(i);
        }

        // Track visited elements
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        // Count the number of swaps
        int swaps = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i] || sortedArr[i] == arr[i]) {
                continue;
            }

            int cycleSize = 0;
            int x = i;
            while (!visited[x]) {
                visited[x] = true;
                x = indexMap.get(sortedArr[x]).poll();
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}

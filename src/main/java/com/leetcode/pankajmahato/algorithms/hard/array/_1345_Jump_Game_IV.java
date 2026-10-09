/**********************************************************************************
 *
 * https://leetcode.com/problems/jump-game-iv/
 *
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * Example 2:
 *
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You do not need to jump.
 * Example 3:
 *
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 108
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _1345_Jump_Game_IV {

    public int minJumps(int[] arr) {

        int n = arr.length;

        // value -> {index1, index2, ...}
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        int steps = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int idx = queue.remove();
                if (idx == n - 1) {
                    return steps;
                }

                int left = idx - 1;
                if (left >= 0 && visited[left] == false) {
                    queue.add(left);
                    visited[left] = true;
                }

                int right = idx + 1;
                if (right < n && visited[right] == false) {
                    queue.add(right);
                    visited[right] = true;
                }

                for (int i : map.getOrDefault(arr[idx], new ArrayList<>())) {
                    if (visited[i] == false) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }

                map.remove(arr[idx]);
            }
            steps++;
        }

        return -1;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/maximize-score-after-n-operations/
 *
 * You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
 *
 * In the ith operation (1-indexed), you will:
 *
 * Choose two elements, x and y.
 * Receive a score of i * gcd(x, y).
 * Remove x and y from nums.
 * Return the maximum score you can receive after performing n operations.
 *
 * The function gcd(x, y) is the greatest common divisor of x and y.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: The optimal choice of operations is:
 * (1 * gcd(1, 2)) = 1
 * Example 2:
 *
 * Input: nums = [3,4,6,8]
 * Output: 11
 * Explanation: The optimal choice of operations is:
 * (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
 * Example 3:
 *
 * Input: nums = [1,2,3,4,5,6]
 * Output: 14
 * Explanation: The optimal choice of operations is:
 * (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
 *
 *
 * Constraints:
 *
 * 1 <= n <= 7
 * nums.length == 2 * n
 * 1 <= nums[i] <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

import java.util.HashMap;
import java.util.Map;

public class _1799_Maximize_Score_After_N_Operations {

    public int maxScore(int[] nums) {

        // DP Top Down

        int n = nums.length;

        boolean[] visited = new boolean[n];

        // key -> index of nums used
        // value -> score
        Map<String, Integer> dp = new HashMap<>();

        return solve(n, nums, visited, 1, dp);
    }

    private int solve(int n, int[] nums, boolean[] visited, int operations, Map<String, Integer> dp) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                sb.append(i).append(",");
            }
        }

        String key = sb.toString();
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int maxScore = 0;

        for (int i = 0; i < n - 1; i++) {

            if (visited[i] == true) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                if (visited[j] == true) {
                    continue;
                }

                visited[i] = true;
                visited[j] = true;

                int currScore = operations * gcd(nums[i], nums[j]);
                int remainingScore = solve(n, nums, visited, operations + 1, dp);

                maxScore = Math.max(maxScore, currScore + remainingScore);

                visited[i] = false;
                visited[j] = false;
            }
        }

        dp.put(key, maxScore);
        return maxScore;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

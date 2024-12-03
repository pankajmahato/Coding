/**********************************************************************************
 *
 * https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/
 *
 * You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:
 *
 *
 * You should build the array arr which has the following properties:
 *
 * arr has exactly n integers.
 * 1 <= arr[i] <= m where (0 <= i < n).
 * After applying the mentioned algorithm to arr, the value search_cost is equal to k.
 * Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2, m = 3, k = 1
 * Output: 6
 * Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
 * Example 2:
 *
 * Input: n = 5, m = 2, k = 3
 * Output: 0
 * Explanation: There are no possible arrays that satisfy the mentioned conditions.
 * Example 3:
 *
 * Input: n = 9, m = 1, k = 1
 * Output: 1
 * Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

import java.util.Arrays;

public class _1420_Build_Array_Where_You_Can_Find_The_Maximum_Exactly_K_Comparisons {

    private int N;
    private int M;
    private int K;
    private final int mod = (int) 1e9 + 7;

    public int numOfArrays(int n, int m, int k) {

        // DP with top down
        N = n;
        M = m;
        K = k;
        int idx = 0;
        int cost = 0;
        int max = 0;

        // dp[n][k][m] = Number of ways for given n(idx), k(cost) and m(max)
        int[][][] dp = new int[n + 1][k + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(idx, cost, max, dp);
    }

    private int solve(int idx, int cost, int max, int[][][] dp) {

        if (idx == N) {
            if (cost == K) {
                return 1;
            }
            return 0;
        } else if (cost > K) {
            return 0;
        }

        if (dp[idx][cost][max] != -1) {
            return dp[idx][cost][max];
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {

            if (i > max) {
                // The number generated is greater so cost is increased and max is updated
                result = (result + solve(idx + 1, cost + 1, i, dp)) % mod;
            } else {
                // This means the number is smaller so cost and max is unchanged
                result = (result + solve(idx + 1, cost, max, dp)) % mod;
            }
        }

        return dp[idx][cost][max] = result;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 * Example 2:
 *
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 3
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 *
 *
 * Constraints:
 *
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _646_Maximum_Length_of_Pair_Chain {

//    public int findLongestChain(int[][] pairs) {
//
//        // DP top down
//        // Sort the pairs based on the right
//        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
//
//        int n = pairs.length;
//
//        // dp[i][j] = Max length of pair chain for i-th index with j-th prev index
//        int dp[][] = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return backtrack(pairs, dp, 0, n, -1);
//    }
//
//    private int backtrack(int[][] pairs, int[][] dp, int idx, int n, int prevIdx) {
//
//        if (idx == n) {
//            return 0;
//        }
//
//        if (prevIdx != -1 && dp[idx][prevIdx] != -1) {
//            return dp[idx][prevIdx];
//        }
//
//        int skip = backtrack(pairs, dp, idx + 1, n, prevIdx);
//
//        int take = 0;
//        if (prevIdx == -1 || pairs[prevIdx][1] < pairs[idx][0]) {
//            take = 1 + backtrack(pairs, dp, idx + 1, n, idx);
//        }
//
//        int result = Math.max(skip, take);
//        if (prevIdx != -1) {
//            dp[idx][prevIdx] = result;
//        }
//
//        return result;
//    }

    public int findLongestChain(int[][] pairs) {

        // DP bottom up
        // Sort the pairs based on the right
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int n = pairs.length;

        // dp[i] = Max length of pair chain till i-th index
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }
}

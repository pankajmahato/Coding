/**********************************************************************************
 *
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _279_Perfect_Squares {

//    public int numSquares(int n) {
//
//        // DP with top down
//
//        // dp[i] = Minimum number of perfect squares which add to i
//        Integer[] dp = new Integer[n + 1];
//
//        return solve(n, dp);
//    }
//
//    private int solve(int n, Integer[] dp) {
//
//        if (n == 0) {
//            return 0;
//        }
//
//        if (dp[n] != null) {
//            return dp[n];
//        }
//
//        // Take all the perfect squares <= n
//        int i = 1;
//        int count = Integer.MAX_VALUE;
//        while (i * i <= n) {
//            count = Math.min(count, 1 + solve(n - i * i, dp));
//            i++;
//        }
//
//        return dp[n] = count;
//    }

    public int numSquares(int n) {

        // DP with bottom up

        // dp[i] = Minimum number of perfect squares which add to i
        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;

        for (int num = 1; num <= n; num++) {
            dp[num] = num;
            for (int i = 1; i * i <= num; i++) {
                dp[num] = Math.min(dp[num], 1 + dp[num - i * i]);
            }
        }

        return dp[n];
    }
}

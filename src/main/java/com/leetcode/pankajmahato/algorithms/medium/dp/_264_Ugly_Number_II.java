/**********************************************************************************
 *
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1690
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _264_Ugly_Number_II {

    public int nthUglyNumber(int n) {

        // DP with bottom up
        // dp[i] = i-th ugly number
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int index2 = 1;
        int index3 = 1;
        int index5 = 1;

        for (int i = 2; i <= n; i++) {
            int factor2 = 2 * dp[index2];
            int factor3 = 3 * dp[index3];
            int factor5 = 5 * dp[index5];

            // Get the next smallest multiple
            int min = Math.min(factor2, Math.min(factor3, factor5));
            dp[i] = min;

            if (factor2 == min) {
                index2++;
            }
            if (factor3 == min) {
                index3++;
            }
            if (factor5 == min) {
                index5++;
            }
        }

        return dp[n];
    }
}

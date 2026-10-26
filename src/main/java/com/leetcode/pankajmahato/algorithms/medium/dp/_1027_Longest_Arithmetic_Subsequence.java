/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-arithmetic-subsequence/
 *
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 *
 * Note that:
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 9, 12]
 *
 * Output: 4
 *
 * Explanation: The whole array is already an arithmetic sequence with a common difference of 3, so the longest arithmetic subsequence is [3, 6, 9, 12], of length 4.
 *
 * Example 2:
 *
 * Input: nums = [9, 4, 7, 2, 10]
 *
 * Output: 3
 *
 * Explanation: The longest arithmetic subsequence is [4, 7, 10] (indices 1, 2, 4), with a common difference of 3. There is no arithmetic subsequence of length 4.
 *
 * Example 3:
 *
 * Input: nums = [20, 1, 15, 3, 10, 5, 8]
 *
 * Output: 4
 *
 * Explanation: The longest arithmetic subsequence is [20, 15, 10, 5] (indices 0, 2, 4, 5), with a common difference of -5.
 *
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 1500
 * 0 <= nums[i] <= 500
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _1027_Longest_Arithmetic_Subsequence {

//    public int longestArithSeqLength(int[] nums) {
//
//        // DP Top Down
//
//        int n = nums.length;
//
//        if (n <= 2) {
//            return n;
//        }
//
//        int maxDiff = 501;
//
//        // Max diff is double if negative number is converted to postive adding maxDiff
//        // dp[i][j] = Result till ith index for diff j
//        int[][] dp = new int[n + 1][2 * maxDiff];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//                int diff = nums[j] - nums[i];
//                int resultLeftOfi = solveLeftOfi(i, diff, n, nums, dp, maxDiff);
//                result = Math.max(result, 2 + resultLeftOfi);
//            }
//        }
//
//        return result;
//    }
//
//    private int solveLeftOfi(int i, int diff, int n, int[] nums, int[][] dp, int maxDiff) {
//
//        if (i < 0) {
//            return 0;
//        }
//
//        if (dp[i][diff + maxDiff] != -1) {
//            return dp[i][diff + maxDiff];
//        }
//
//        int result = 0;
//
//        for (int k = i - 1; k >= 0; k--) {
//            if (nums[i] - nums[k] == diff) {
//                int resultLeftOfk = solveLeftOfi(k, diff, n, nums, dp, maxDiff);
//                result = Math.max(result, 1 + resultLeftOfk);
//            }
//        }
//
//        return dp[i][diff + maxDiff] = result;
//    }

    public int longestArithSeqLength(int[] nums) {

        // DP Bottom Up

        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int maxDiff = 501;

        // Max diff is double if negative number is converted to postive adding maxDiff
        // dp[i][j] = Result till ith index for diff j
        int[][] dp = new int[n + 1][2 * maxDiff];

        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                int diff = nums[j] - nums[i] + maxDiff;
                if (dp[j][diff] > 0) {
                    // Adding 1 as j has the same diff as i
                    dp[i][diff] = dp[j][diff] + 1;
                } else {
                    // Any i & j form the Sequence of length 2
                    dp[i][diff] = 2;
                }

                result = Math.max(result, dp[i][diff]);
            }
        }

        return result;
    }
}

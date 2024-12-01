/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 *
 * The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.
 *
 * For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
 * Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).
 *
 * A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,3]
 * Output: 7
 * Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
 * Example 2:
 *
 * Input: nums = [5,6,7,8]
 * Output: 8
 * Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
 * Example 3:
 *
 * Input: nums = [6,2,1,2,4,5]
 * Output: 10
 * Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _1911_Maximum_Alternating_Subsequence_Sum {

//    public long maxAlternatingSum(int[] nums) {
//
//        // DP with memoization(top down)
//        int n = nums.length;
//
//        // dp[i][j] = Max alternating sum till i-th index of length j; where j = 0 or 1 (0 - even, 1 - odd)
//        long[][] dp = new long[n + 1][2];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = -1;
//            dp[i][1] = -1;
//        }
//
//        return solve(nums, n, dp, 0, 0);
//
//    }
//
//    private long solve(int[] nums, int n, long[][] dp, int idx, int isEven) {
//
//        if (idx >= n) {
//            return 0;
//        }
//
//        if (dp[idx][isEven] != -1) {
//            return dp[idx][isEven];
//        }
//
//        long skip = solve(nums, n, dp, idx + 1, isEven);
//
//        int val = nums[idx];
//        if (isEven == 1) {
//            val = -val;
//        }
//
//        long take = val + solve(nums, n, dp, idx + 1, 1 - isEven);
//
//        return dp[idx][isEven] = Math.max(skip, take);
//    }

    public long maxAlternatingSum(int[] nums) {

        // DP bottom up
        int n = nums.length;

        // dp[i][j] = Max alternating sum till i-th index of length j; where j = 0 or 1
        // (0 - even, 1 - odd)
        long[][] dp = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        dp[0][0] = 0;
        dp[0][1] = 0;

        // using i as 1-based index
        for (int i = 1; i <= n; i++) {

            // if length of subsequence is even (index is odd) (length is even)
            // prevSum must be of odd length
            long evenSum = dp[i - 1][1] - nums[i - 1]; // subtracting as i is odd index
            // Store current sum of even length
            dp[i][0] = Math.max(evenSum, dp[i - 1][0]);

            // if length of subsequence is odd (index is even) (length is odd)
            // prevSum must be of even length
            long oddSum = dp[i - 1][0] + nums[i - 1]; // adding as i is even index
            // Store current sum of odd length
            dp[i][1] = Math.max(oddSum, dp[i - 1][1]);

        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}

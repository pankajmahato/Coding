/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing 
 * subsequence
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _300_Longest_Increasing_Subsequence {

//    public int lengthOfLIS(int[] nums) {
//
//        // DP with top down
//        int n = nums.length;
//
//        // dp[i][j] = longest increasing subsequence till i-th index with j-th prev index
//        int[][] dp = new int[n + 1][n + 1];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//
//        return backtrack(nums, n, dp, 0, -1);
//    }
//
//    private int backtrack(int[] nums, int n, int[][] dp, int idx, int prev) {
//
//        if (idx == n) {
//            return 0;
//        }
//
//        if (prev != -1 && dp[idx][prev] != -1) {
//            return dp[idx][prev];
//        }
//
//        // Skip number
//        int skipLen = backtrack(nums, n, dp, idx + 1, prev);
//
//        // Take number after comparing with prev index
//        int takeLen = 0;
//        if (prev == -1 || nums[idx] > nums[prev]) {
//            takeLen = backtrack(nums, n, dp, idx + 1, idx) + 1;
//        }
//
//        int result = Math.max(skipLen, takeLen);
//        if (prev != -1) {
//            dp[idx][prev] = result;
//        }
//        return result;
//    }

    public int lengthOfLIS(int[] nums) {

        // DP with bottom up
        int n = nums.length;

        // dp[i] = longest increasing subsequence ending at i-th index
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {

            // check for every i-th element where it can be placed for j
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}

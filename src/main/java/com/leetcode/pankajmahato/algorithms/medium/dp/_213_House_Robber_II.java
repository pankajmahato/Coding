/**********************************************************************************
 *
 * https://leetcode.com/problems/house-robber-ii/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _213_House_Robber_II {

//    public int rob(int[] nums) {
//
//        // DP
//        int n = nums.length;
//
//        if (n == 1) {
//            return nums[0];
//        }
//
//        // dp[i] = max money stolen till i-th house
//        int[] dp = new int[n + 1];
//
//        // Case 1: take 1st(0-th index) house - skip last
//        solve(nums, dp, 1, n - 1);
//        int result1 = dp[n - 1];
//
//        // Case 2: take 2nd(1st index) house - take last
//        Arrays.fill(dp, 0);
//        dp[1] = 0;
//        solve(nums, dp, 2, n);
//        int result2 = dp[n];
//
//        return Math.max(result1, result2);
//    }
//
//    private void solve(int[] nums, int[] dp, int start, int end) {
//        for (int i = start; i <= end; i++) {
//
//            int skip = dp[i - 1];
//            int take = (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i - 1];
//            dp[i] = Math.max(skip, take);
//        }
//    }

    public int rob(int[] nums) {

        // DP with O(1) space
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Case 1: take 1st(0-th index) house - skip last
        int result1 = solve(nums, 0, n - 2);

        // Case 2: take 2nd(1st index) house - take last
        int result2 = solve(nums, 1, n - 1);

        return Math.max(result1, result2);
    }

    private int solve(int[] nums, int start, int end) {

        int prevPrev = 0;
        int prev = 0;

        for (int i = start; i <= end; i++) {

            int skip = prev;
            int take = prevPrev + nums[i];
            prevPrev = prev;
            prev = Math.max(skip, take);
        }

        return prev;
    }
}

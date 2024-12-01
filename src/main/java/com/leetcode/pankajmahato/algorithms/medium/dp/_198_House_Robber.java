/**********************************************************************************
 *
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _198_House_Robber {

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
//        dp[1] = nums[0];
//        dp[2] = Math.max(dp[0] + nums[1], dp[1]);
//
//        for (int i = 3; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
//        }
//
//        return dp[n];
//    }

    public int rob(int[] nums) {

        // DP with O(1) space
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int prevPrev = nums[0];
        int prev = Math.max(nums[1], prevPrev);

        for (int i = 3; i <= n; i++) {

            int skip = prev;
            int steal = prevPrev + nums[i - 1];
            prevPrev = prev;
            prev = Math.max(skip, steal);
        }

        return prev;
    }
}

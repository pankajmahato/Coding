/**********************************************************************************
 *
 * https://leetcode.com/problems/jump-game/
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _55_Jump_Game {

//    public boolean canJump(int[] nums) {
//
//        // DP with top down
//        int n = nums.length;
//
//        // dp[i] = is it possible to reach i-th index
//        Boolean[] dp = new Boolean[n];
//
//        return solve(nums, n, 0, dp);
//    }
//
//    private boolean solve(int[] nums, int n, int idx, Boolean[] dp) {
//
//        if (idx == n - 1) {
//            return true;
//        }
//
//        if (dp[idx] != null) {
//            return dp[idx];
//        }
//
//        for (int i = 1; i <= nums[idx]; i++) {
//            boolean isPossible = dp[idx + i] = solve(nums, n, idx + i, dp);
//            if (isPossible == true) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//    public boolean canJump(int[] nums) {
//
//        // DP with bottom up
//        int n = nums.length;
//
//        // dp[i] = is it possible to reach i-th index
//        boolean[] dp = new boolean[n];
//        dp[0] = true;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//
//                if (dp[j] == true && nums[j] - (i - j) >= 0) {
//                    dp[i] = true;
//                    break;
//                }
//
//            }
//        }
//
//        return dp[n - 1];
//    }

    public boolean canJump(int[] nums) {

        // DP with bottom up (optimised)
        int n = nums.length;

        int maxReachable = 0;

        for (int i = 0; i < n; i++) {
            if (i <= maxReachable) {
                maxReachable = Math.max(maxReachable, nums[i] + i);
            } else {
                break;
            }
        }

        return maxReachable >= n - 1;
    }
}


/**********************************************************************************
 *
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 *
 * Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 * Example 2:
 *
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * Example 3:
 *
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 4 * 104
 * 1 <= nums[i] <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1262_Greatest_Sum_Divisible_by_Three {

//    public int maxSumDivThree(int[] nums) {
//
//        // O(n*logn)
//
//        int n = nums.length;
//
//        List<Integer> remainder1 = new ArrayList<>();
//        List<Integer> remainder2 = new ArrayList<>();
//
//        int sum = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            sum += nums[i];
//            if (nums[i] % 3 == 1) {
//                remainder1.add(nums[i]);
//            }
//
//            if (nums[i] % 3 == 2) {
//                remainder2.add(nums[i]);
//            }
//        }
//
//        int rem = sum % 3;
//        if (rem == 0) {
//            return sum;
//        }
//
//        Collections.sort(remainder1);
//        Collections.sort(remainder2);
//
//        if (rem == 1) {
//            // Pick the single nummber which has remainder 1
//            int option1 = remainder1.size() >= 1 ? remainder1.get(0) : Integer.MAX_VALUE;
//
//            // Pick the 2 numbers which has remainder 2
//            int option2 = remainder2.size() >= 2 ? remainder2.get(0) + remainder2.get(1) : Integer.MAX_VALUE;
//
//            return sum - Math.min(option1, option2);
//        }
//
//        if (rem == 2) {
//            // Pick the single nummber which has remainder 2
//            int option1 = remainder2.size() >= 1 ? remainder2.get(0) : Integer.MAX_VALUE;
//
//            // Pick the 2 numbers which has remainder 1
//            int option2 = remainder1.size() >= 2 ? remainder1.get(0) + remainder1.get(1) : Integer.MAX_VALUE;
//
//            return sum - Math.min(option1, option2);
//        }
//
//        return -1;
//    }

    public int maxSumDivThree(int[] nums) {

        // O(n) -> Top Down

        int n = nums.length;

        int[][] dp = new int[n][3];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return solveTopDown(0, 0, nums, dp);
    }

    private int solveTopDown(int i, int rem, int[] nums, int[][] dp) {

        if (i >= nums.length) {
            if (rem == 0) {
                return 0;
            }

            return Integer.MIN_VALUE;
        }

        if (dp[i][rem] != -1) {
            return dp[i][rem];
        }

        int take = nums[i] + solveTopDown(i + 1, (rem + nums[i]) % 3, nums, dp);

        int skip = solveTopDown(i + 1, rem, nums, dp);

        return dp[i][rem] = Math.max(take, skip);
    }

//    public int maxSumDivThree(int[] nums) {
//
//        // O(n) -> Bottom Up
//
//        int n = nums.length;
//
//        // dp[i][rem] = result from ith to n index having rem
//        int[][] dp = new int[n + 1][3];
//        for (int[] d : dp) {
//            Arrays.fill(d, -1);
//        }
//
//        dp[n][0] = 0;
//        dp[n][1] = Integer.MIN_VALUE;
//        dp[n][2] = Integer.MIN_VALUE;
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int rem = 0; rem < 3; rem++) {
//
//                int newRemainder = (rem + nums[i]) % 3;
//
//                int take = nums[i] + dp[i + 1][newRemainder];
//
//                int skip = dp[i + 1][rem];
//
//                dp[i][rem] = Math.max(take, skip);
//            }
//        }
//
//        return dp[0][0];
//    }
}

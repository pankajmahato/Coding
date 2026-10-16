/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Given an integer array nums, return the number of longest increasing subsequences.
 *
 * Notice that the sequence has to be strictly increasing.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 * The answer is guaranteed to fit inside a 32-bit integer.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _673_Number_of_Longest_Increasing_Subsequence {

    public int findNumberOfLIS(int[] nums) {

        // DP Bottom Up

        int n = nums.length;

        // dp[i] = Length of LIS ending at ith index
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // count[i] = Count of Length of LIS ending at ith index
        int[] count = new int[n];
        Arrays.fill(count, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }

        return result;
    }
}

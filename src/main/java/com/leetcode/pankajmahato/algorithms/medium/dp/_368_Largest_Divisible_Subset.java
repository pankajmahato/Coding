/**********************************************************************************
 *
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * All the integers in nums are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368_Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        // DP with bottom up
        int n = nums.length;

        Arrays.sort(nums);

        // dp[i] = Longest length of subset ending at i-th index
        int[] dp = new int[n];

        // prev[i] = previous index of the subset at i-th index
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // If divisible store the length and it's previous index
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    prev[i] = j;
                    if (maxLen <= dp[i]) {
                        maxLen = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        // Order doesn't matter as we have to return subset
        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        return result;
    }
}

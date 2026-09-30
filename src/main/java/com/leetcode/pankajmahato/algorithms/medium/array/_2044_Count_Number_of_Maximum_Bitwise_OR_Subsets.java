/**********************************************************************************
 *
 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
 *
 * Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.
 *
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.
 *
 * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1]
 * Output: 2
 * Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
 * - [3]
 * - [3,1]
 * Example 2:
 *
 * Input: nums = [2,2,2]
 * Output: 7
 * Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
 * Example 3:
 *
 * Input: nums = [3,2,1,5]
 * Output: 6
 * Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;

public class _2044_Count_Number_of_Maximum_Bitwise_OR_Subsets {

    public int countMaxOrSubsets(int[] nums) {

        int n = nums.length;

        int maxOr = 0;
        for (int num : nums) {
            maxOr = maxOr | num;
        }

        int[][] dp = new int[n + 1][maxOr + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getCount(0, 0, nums, maxOr, dp);
    }

    private int getCount(int idx, int currOr, int[] nums, int maxOr, int[][] dp) {

        if (idx == nums.length) {
            if (currOr == maxOr) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[idx][currOr] != -1) {
            return dp[idx][currOr];
        }

        // Take idx
        int take = getCount(idx + 1, currOr | nums[idx], nums, maxOr, dp);

        // Skip idx
        int skip = getCount(idx + 1, currOr, nums, maxOr, dp);

        return dp[idx][currOr] = take + skip;
    }
}

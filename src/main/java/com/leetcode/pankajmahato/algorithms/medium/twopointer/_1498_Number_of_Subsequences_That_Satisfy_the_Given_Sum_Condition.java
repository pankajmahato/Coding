/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 *
 * You are given an array of integers nums and an integer target.
 *
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,5,6,7], target = 9
 * Output: 4
 * Explanation: There are 4 subsequences that satisfy the condition.
 * [3] -> Min value + max value <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * Example 2:
 *
 * Input: nums = [3,3,6,8], target = 10
 * Output: 6
 * Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * Example 3:
 *
 * Input: nums = [2,3,3,4,6,7], target = 12
 * Output: 61
 * Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
 * Number of valid subsequences (63 - 2 = 61).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.twopointer;

import java.util.Arrays;

public class _1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {

    public int numSubseq(int[] nums, int target) {

        int result = 0;

        int l = 0;
        int r = nums.length - 1;
        int mod = (int) 1e9 + 7;

        Arrays.sort(nums);

        // Precompute all the powers as the input is very large
        int[] powers = new int[nums.length];
        powers[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            powers[i] = (powers[i - 1] * 2) % mod;
        }

        while (l <= r) {

            if (nums[l] + nums[r] <= target) {
                result = (result + powers[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 *
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 *
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions. If no such pair of indices exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [18,43,36,13,7]
 * Output: 54
 * Explanation: The pairs (i, j) that satisfy the conditions are:
 * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
 * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
 * So the maximum sum that we can obtain is 54.
 * Example 2:
 *
 * Input: nums = [10,12,19,14]
 * Output: -1
 * Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _2342_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {

    public int maximumSum(int[] nums) {

        int n = nums.length;

        // There can be maximum sum of digits 81 if n <= 10^9 (all 9's)
        int[] sumMap = new int[82];

        int result = -1;
        for (int i = 0; i < n; i++) {
            int sum = sumOfDigits(nums[i]);
            if (sumMap[sum] > 0) {
                result = Math.max(result, nums[i] + sumMap[sum]);
            }

            sumMap[sum] = Math.max(sumMap[sum], nums[i]);
        }

        return result;
    }

    private int sumOfDigits(int n) {

        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }
}

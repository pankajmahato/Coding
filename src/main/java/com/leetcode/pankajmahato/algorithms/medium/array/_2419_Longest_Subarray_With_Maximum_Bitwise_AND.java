/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
 *
 * You are given an integer array nums of size n.
 *
 * Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
 *
 * In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
 * Return the length of the longest such subarray.
 *
 * The bitwise AND of an array is the bitwise AND of all the numbers in it.
 *
 * A subarray is a contiguous sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,2,2]
 * Output: 2
 * Explanation:
 * The maximum possible bitwise AND of a subarray is 3.
 * The longest subarray with that value is [3,3], so we return 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 1
 * Explanation:
 * The maximum possible bitwise AND of a subarray is 4.
 * The longest subarray with that value is [4], so we return 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _2419_Longest_Subarray_With_Maximum_Bitwise_AND {

    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int streak = 0;
        int maxLength = 0;

        // Bitwise AND operation makes the result always less than or equal to both operands. So max will always be the largest number
        // a & b  = c; { c <= a AND c <= b }

        for (int i = 0; i < n; i++) {

            if (max < nums[i]) {
                max = nums[i];
                streak = 0;
                maxLength = 0;
            }

            if (max == nums[i]) {
                streak++;
            } else {
                streak = 0;
            }

            maxLength = Math.max(maxLength, streak);
        }

        return maxLength;
    }
}

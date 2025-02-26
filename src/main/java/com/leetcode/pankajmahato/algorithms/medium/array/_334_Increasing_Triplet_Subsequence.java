/**********************************************************************************
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _334_Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {

        int n = nums.length;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int num3 = nums[i];

            if (num3 <= num1) {
                num1 = num3;
            } else if (num3 <= num2) {
                num2 = num3;
            } else {
                return true;
            }
        }

        return false;

    }
}

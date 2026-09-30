/**********************************************************************************
 *
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * The input is generated such that a majority element will exist in the array.
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.array;

public class _169_Majority_Element {

    public int majorityElement(int[] nums) {

        int n = nums.length;

        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < n; i++) {

            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}

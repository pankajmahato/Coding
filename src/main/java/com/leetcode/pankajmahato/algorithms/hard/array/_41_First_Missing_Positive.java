/**********************************************************************************
 *
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

public class _41_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        //set any 0 or negative number as the size of the array + 1
        //[1,2,*-3*,4] => [1,2,*5*,4]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        //if the absolute value is a valid position of this array, then
        //negate the value of the respective index
        // [1,2,5,4] =>  [-1,-2,5,-4]
        for (int i = 0; i < nums.length; i++) {
            int valueIdx = Math.abs(nums[i]) - 1;
            if (valueIdx + 1 > 0 && valueIdx + 1 <= nums.length) {
                nums[valueIdx] = -Math.abs(nums[valueIdx]);
            }
        }

        //traverse the array from left to right
        //if there's any positive number then
        //we found the missing positive number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1) {
                return i + 1;
            }
        }

        //if all elements of the array are correct
        //return the length of the array + 1
        return nums.length + 1;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {

        int firstIndex = binarySearch(nums, target, true);
        int lastIndex = binarySearch(nums, target, false);

        return new int[]{firstIndex, lastIndex};
    }

    private int binarySearch(int[] arr, int val, boolean isFirst) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (low <= high) {

            mid = low + (high - low) / 2;
            if (arr[mid] == val) {
                index = mid;
                if (isFirst) {
                    high--;
                } else {
                    low++;
                }
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}

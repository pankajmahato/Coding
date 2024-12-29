/**********************************************************************************
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _33_Search_in_Rotated_Sorted_Array {
//    public int search(int[] nums, int target) {
//
//        int low = 0;
//        int high = nums.length - 1;
//        int mid = 0;
//        while (low <= high) {
//
//            mid = low + (high - low) / 2;
//
//            if (nums[mid] == target) {
//                return mid;
//            }
//
//            if (nums[low] <= nums[mid]) {
//                if (target < nums[mid] && target >= nums[low]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else {
//                if (target > nums[mid] && target <= nums[high]) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums, 0, n - 1);

        int idx = binarySearch(nums, 0, pivot - 1, target);

        if (idx != -1) {
            return idx;
        }

        idx = binarySearch(nums, pivot, n - 1, target);

        return idx;
    }

    private int findPivot(int[] nums, int l, int r) {

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

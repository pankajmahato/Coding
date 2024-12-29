/**********************************************************************************
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 *
 *
 * Follow up: This problem is the same as Search in Rotated Sorted Array, where nums may contain duplicates. Would this affect the runtime complexity? How and why?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _81_Search_in_Rotated_Sorted_Array_II {
//    public boolean search(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        int mid = 0;
//        while (low <= high) {
//
//            mid = low + (high - low) / 2;
//
//            if (nums[mid] == target || nums[high] == target) {
//                return true;
//            }
//
//            if (nums[low] < nums[mid]) {
//                if (target <= nums[mid] && target >= nums[low]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else if (nums[low] > nums[mid]) {
//                if (target >= nums[mid] && target <= nums[high]) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            } else {
//                high--;
//            }
//        }
//        return false;
//    }

    public boolean search(int[] nums, int target) {

        int n = nums.length;

        int pivot = findPivot(nums, 0, n - 1);

        int idx = binarySearch(nums, 0, pivot - 1, target);

        if (idx != -1) {
            return true;
        }

        idx = binarySearch(nums, pivot, n - 1, target);

        if (idx == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int findPivot(int[] nums, int l, int r) {

        while (l < r) {

            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }

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

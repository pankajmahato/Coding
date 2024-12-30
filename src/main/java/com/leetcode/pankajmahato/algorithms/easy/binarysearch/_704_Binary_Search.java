/**********************************************************************************
 *
 * https://leetcode.com/problems/binary-search/
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.binarysearch;

public class _704_Binary_Search {

//    public int search(int[] nums, int target) {
//
//        int l = 0;
//        int r = nums.length - 1;
//
//        while (l <= r) {
//
//            int mid = l + (r - l) / 2;
//            if (nums[mid] > target) {
//                r = mid - 1;
//            } else if (nums[mid] < target) {
//                l = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//
//        return -1;
//    }

    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        return solve(nums, l, r, target);
    }

    private int solve(int[] nums, int l, int r, int target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (nums[mid] > target) {
            return solve(nums, l, mid - 1, target);
        } else if (nums[mid] < target) {
            return solve(nums, mid + 1, r, target);
        } else {
            return mid;
        }
    }
}

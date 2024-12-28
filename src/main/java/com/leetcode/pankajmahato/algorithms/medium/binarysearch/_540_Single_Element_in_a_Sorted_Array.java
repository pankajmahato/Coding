/**********************************************************************************
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _540_Single_Element_in_a_Sorted_Array {

    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            // Number of elements on right of mid
            boolean isEvenRightSide;
            if ((r - mid) % 2 == 0) {
                isEvenRightSide = true;
            } else {
                isEvenRightSide = false;
            }

            if (nums[mid] == nums[mid + 1]) {

                // There are odd number of elements after mid so eliminate left
                if (isEvenRightSide) {
                    l = mid + 2;
                } else {
                    // There are even number of elements after mid so eliminate right
                    r = mid - 1;
                }
            } else {
                // There are even number of elements after mid so eliminate right
                if (isEvenRightSide) {
                    r = mid;
                } else {
                    // There are odd number of elements after mid so eliminate left
                    l = mid + 1;
                }
            }
        }

        return nums[r];
    }
}

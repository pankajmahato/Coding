/**********************************************************************************
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard;

public class _4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int part1 = low + (high - low) / 2;
            int part2 = (nums1.length + nums2.length + 1) / 2 - part1;

            int l1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
            int l2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
            int r1 = part1 == nums1.length ? Integer.MAX_VALUE : nums1[part1];
            int r2 = part2 == nums2.length ? Integer.MAX_VALUE : nums2[part2];

            if (l1 > r2) {
                high = part1 - 1;
            } else if (l2 > r1) {
                low = part1 + 1;
            } else {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
        }

        return 0;
    }
}

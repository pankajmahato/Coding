/**********************************************************************************
 *
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
 *
 * Return the index of the peak element.
 *
 * Your task is to solve it in O(log(n)) time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [0,1,0]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: arr = [0,2,1,0]
 *
 * Output: 1
 *
 * Example 3:
 *
 * Input: arr = [0,10,5,2]
 *
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 105
 * 0 <= arr[i] <= 106
 * arr is guaranteed to be a mountain array.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _852_Peak_Index_in_a_Mountain_Array {

    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;

        int l = 0;
        int r = n - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }
}
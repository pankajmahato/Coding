/**********************************************************************************
 *
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * Example 2:
 *
 * Input: arr = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.array;

public class _1287_Element_Appearing_More_Than_25_In_Sorted_Array {

    public int findSpecialInteger(int[] arr) {

        int n = arr.length;
        int freq = n / 4;

        for (int i = freq; i < n; i += freq) {

            int leftIndex = binarySearch(arr, arr[i], true);
            int rightIndex = binarySearch(arr, arr[i], false);

            if (rightIndex - leftIndex + 1 > freq) {
                return arr[i];
            }
        }

        return -1;
    }

    private int binarySearch(int[] arr, int target, boolean isFirst) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

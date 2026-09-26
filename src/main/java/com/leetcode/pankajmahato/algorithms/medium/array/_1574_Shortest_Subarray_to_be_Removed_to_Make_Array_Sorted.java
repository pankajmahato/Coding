/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 *
 * Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 *
 * Return the length of the shortest subarray to remove.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 * Example 2:
 *
 * Input: arr = [5,4,3,2,1]
 * Output: 4
 * Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
 * Example 3:
 *
 * Input: arr = [1,2,3]
 * Output: 0
 * Explanation: The array is already non-decreasing. We do not need to remove any elements.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 105
 * 0 <= arr[i] <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _1574_Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {

    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;

        int j = n - 1;

        // Find the smallest from right
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        // Remove all numbers left of j
        int result = j;

        int i = 0;

        while (i < j && (i == 0 || arr[i] >= arr[i - 1])) {

            while (j < n && arr[i] > arr[j]) {
                j++;
            }

            // Remove number from i to j-1
            result = Math.min(result, j - i - 1);
            i++;
        }

        return result;
    }
}

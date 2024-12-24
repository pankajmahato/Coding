/**********************************************************************************
 *
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 *
 * You are given an integer array nums and a positive integer k.
 *
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 *
 * A subarray is a contiguous sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * Example 2:
 *
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


public class _2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {

    public long countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int countMax = 0;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }

        long result = 0;
        int i = 0;
        int j = 0;

        while (j < n) {

            if (nums[j] == maxNum) {
                countMax++;

                while (countMax >= k) {
                    // Number of subarrays starting at i-th index with j-th index = n - j
                    result = result + n - j;

                    if (nums[i] == maxNum) {
                        countMax--;
                    }
                    i++;
                }
            }

            j++;
        }

        return result;
    }
}

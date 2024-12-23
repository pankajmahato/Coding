/**********************************************************************************
 *
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.slidingwindow;


public class _713_Subarray_Product_Less_Than_K {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }
        int n = nums.length;

        long product = 1;
        int count = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            product *= (long) nums[j];
            while (i < n && product >= k) {
                product /= (long) nums[i];
                i++;
            }
            // Number of subarrays ending at j-th index
            int windowSize = j - i + 1;
            count = count + windowSize;
            j++;
        }

        return count;
    }
}

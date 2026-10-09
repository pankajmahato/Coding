
/**********************************************************************************
 *
 * https://leetcode.com/problems/patching-array/
 *
 * Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
 *
 * Return the minimum number of patches required.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3], n = 6
 * Output: 1
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * Example 2:
 *
 * Input: nums = [1,5,10], n = 20
 * Output: 2
 * Explanation: The two patches can be [2, 4].
 * Example 3:
 *
 * Input: nums = [1,2,2], n = 5
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * nums is sorted in ascending order.
 * 1 <= n <= 231 - 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.greedy;

public class _330_Patching_Array {

    public int minPatches(int[] nums, int n) {

        long maxNumberFormed = 0;
        int patches = 0;
        int i = 0;

        // Observation
        // Maximum Number reachable by set { 1, x, ..., y} is R
        // Then if we add z to set then the max reachable  = R + z
        // As all numbers from 1 to R are already reachable so we can pick the combination to which gives (R - z + a)
        // Now if z is added then we get (R + a); Where a = 1, 2, 3, ..., z
        while (maxNumberFormed < n) {

            if (i < nums.length && nums[i] <= maxNumberFormed + 1) {
                // Maximum numbers formed is less than or equal to the (curr + 1) so include the current one and use it to reach higher number
                maxNumberFormed += nums[i];
                i++;
            } else {
                // There are still gaps so add the next max number
                maxNumberFormed += maxNumberFormed + 1;
                // Patched number is (maxNumberFormed + 1)
                patches++;
            }
        }

        return patches;
    }
}


/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/
 *
 * You are given an integer array nums and an integer k.
 *
 * You are allowed to perform the following operation on each element of the array at most once:
 *
 * Add an integer in the range [-k, k] to the element.
 * Return the maximum possible number of distinct elements in nums after performing the operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,3,4], k = 2
 *
 * Output: 6
 *
 * Explanation:
 *
 * nums changes to [-1, 0, 1, 2, 3, 4] after performing operations on the first four elements.
 *
 * Example 2:
 *
 * Input: nums = [4,4,4,4], k = 1
 *
 * Output: 3
 *
 * Explanation:
 *
 * By adding -1 to nums[0] and 1 to nums[1], nums changes to [3, 5, 4, 4].
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 0 <= k <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.greedy;

import java.util.Arrays;

public class _3397_Maximum_Number_of_Distinct_Elements_After_Operations {

    public int maxDistinctElements(int[] nums, int k) {

        int n = nums.length;
        Arrays.sort(nums);

        int prevMax = -k - 1;
        int result = 0;
        for (int i = 0; i < n; i++) {

            int smallest = nums[i] - k;
            if (smallest > prevMax) {
                nums[i] = smallest;
                result++;
            } else if (prevMax + 1 <= nums[i] + k) {
                nums[i] = prevMax + 1;
                result++;
            }

            prevMax = Math.max(prevMax, nums[i]);
        }

        return result;
    }
}

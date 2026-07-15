/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 *
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 *
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _1658_Minimum_Operations_to_Reduce_X_to_Zero {

    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum = totalSum + nums[i];
        }

        int target = totalSum - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int minOperations = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        int right = 0;

        while (right < n) {

            currentSum = currentSum + nums[right];
            right++;

            while (currentSum > target && left < n) {
                currentSum = currentSum - nums[left];
                left++;
            }

            if (currentSum == target) {
                minOperations = Math.min(minOperations, n - (right - left));
            }
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}

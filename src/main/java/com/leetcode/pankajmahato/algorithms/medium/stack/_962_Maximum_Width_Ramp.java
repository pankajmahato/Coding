/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
 *
 * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [6,0,8,2,1,5]
 * Output: 4
 * Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
 * Example 2:
 *
 * Input: nums = [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5 * 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _962_Maximum_Width_Ramp {

    public int maxWidthRamp(int[] nums) {

        int n = nums.length;

        // Monotonic decreasing stack
        Deque<int[]> stack = new ArrayDeque<>();

        // Store the lowest index numbers in descreasing order
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek()[0] > nums[i]) {
                stack.push(new int[]{nums[i], i});
            }
        }

        // Traverse from right side as this will be the max pair with the stack's top
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                result = Math.max(result, i - stack.peek()[1]);
                stack.pop();
            }
        }

        return result;
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/132-pattern/
 *
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 *
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 *
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _456_132_Pattern {

    public boolean find132pattern(int[] nums) {

        // i < j < k
        // num1 < num3 < num2
        Deque<Integer> stack = new ArrayDeque<>();

        int num3 = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < num3) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                num3 = stack.peek();
                stack.pop();
            }

            stack.push(nums[i]);

        }

        return false;
    }
}

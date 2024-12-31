/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-cost-to-make-array-equal/
 *
 * You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
 *
 * You can do the following operation any number of times:
 *
 * Increase or decrease any element of the array nums by 1.
 * The cost of doing one operation on the ith element is cost[i].
 *
 * Return the minimum total cost such that all the elements of the array nums become equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,2], cost = [2,3,1,14]
 * Output: 8
 * Explanation: We can make all the elements equal to 2 in the following way:
 * - Increase the 0th element one time. The cost is 2.
 * - Decrease the 1st element one time. The cost is 3.
 * - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
 * The total cost is 2 + 3 + 3 = 8.
 * It can be shown that we cannot make the array equal with a smaller cost.
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
 * Output: 0
 * Explanation: All the elements are already equal, so no operations are needed.
 *
 *
 * Constraints:
 *
 * n == nums.length == cost.length
 * 1 <= n <= 105
 * 1 <= nums[i], cost[i] <= 106
 * Test cases are generated in a way that the output doesn't exceed 253-1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.binarysearch;

public class _2448_Minimum_Cost_to_Make_Array_Equal {

    public long minCost(int[] nums, int[] cost) {

        int n = nums.length;

        long l = nums[0];
        long r = nums[0];

        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        long result = Long.MAX_VALUE;

        while (l <= r) {

            long mid = l + (r - l) / 2;

            long midCost = getCost(nums, cost, mid);
            long mid1Cost = getCost(nums, cost, mid + 1);

            result = Math.min(midCost, mid1Cost);

            if (midCost <= mid1Cost) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private long getCost(int[] nums, int[] cost, long val) {

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (Math.abs(val - nums[i]) * (long) cost[i]);
        }

        return sum;
    }
}

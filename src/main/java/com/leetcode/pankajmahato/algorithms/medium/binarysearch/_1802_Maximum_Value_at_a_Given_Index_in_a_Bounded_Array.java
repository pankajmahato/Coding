/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 *
 * You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
 *
 * nums.length == n
 * nums[i] is a positive integer where 0 <= i < n.
 * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
 * The sum of all the elements of nums does not exceed maxSum.
 * nums[index] is maximized.
 * Return nums[index] of the constructed array.
 *
 * Note that abs(x) equals x if x >= 0, and -x otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, index = 2,  maxSum = 6
 * Output: 2
 * Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
 * There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
 * Example 2:
 *
 * Input: n = 6, index = 1,  maxSum = 10
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= maxSum <= 109
 * 0 <= index < n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _1802_Maximum_Value_at_a_Given_Index_in_a_Bounded_Array {

    public int maxValue(int n, int index, int maxSum) {

        int l = 1;
        int r = maxSum;
        int result = 0;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            int leftCount = Math.min(index, mid - 1);
            long leftSum = getSum(leftCount, mid);
            leftSum += Math.max(0, index - (mid - 1)); // Extra 1's if any

            int rightCount = Math.min(n - index - 1, mid - 1);
            long rightSum = getSum(rightCount, mid);
            rightSum += Math.max(0, n - index - 1 - (mid - 1)); // Extra 1's if any

            long totalSum = leftSum + mid + rightSum;

            if (totalSum <= maxSum) {
                result = Math.max(result, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    private long getSum(long count, long x) {

        return (count * x) - (count * (count + 1) / 2);
    }
}

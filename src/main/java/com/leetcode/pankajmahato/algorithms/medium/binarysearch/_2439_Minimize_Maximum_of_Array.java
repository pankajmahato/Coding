
/**********************************************************************************
 *
 * https://leetcode.com/problems/minimize-maximum-of-array/
 *
 * You are given a 0-indexed array nums comprising of n non-negative integers.
 *
 * In one operation, you must:
 *
 * Choose an integer i such that 1 <= i < n and nums[i] > 0.
 * Decrease nums[i] by 1.
 * Increase nums[i - 1] by 1.
 * Return the minimum possible value of the maximum integer of nums after performing any number of operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,7,1,6]
 * Output: 5
 * Explanation:
 * One set of optimal operations is as follows:
 * 1. Choose i = 1, and nums becomes [4,6,1,6].
 * 2. Choose i = 3, and nums becomes [4,6,2,5].
 * 3. Choose i = 1, and nums becomes [5,5,2,5].
 * The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
 * Therefore, we return 5.
 * Example 2:
 *
 * Input: nums = [10,1]
 * Output: 10
 * Explanation:
 * It is optimal to leave nums as is, and since 10 is the maximum value, we return 10.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 2 <= n <= 105
 * 0 <= nums[i] <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

import java.util.Arrays;

public class _2439_Minimize_Maximum_of_Array {

    public int minimizeArrayValue(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = Integer.MIN_VALUE;
        for (int num : nums) {
            r = Math.max(r, num);
        }

        int result = 0;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (isValid(nums, n, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    private boolean isValid(int[] nums, int n, int target) {

        long[] arr = Arrays.stream(nums).mapToLong(i -> i).toArray();

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > target) {
                return false;
            }

            long buffer = target - arr[i];
            arr[i + 1] = arr[i + 1] - buffer;
        }

        return arr[n - 1] <= target;
    }
}

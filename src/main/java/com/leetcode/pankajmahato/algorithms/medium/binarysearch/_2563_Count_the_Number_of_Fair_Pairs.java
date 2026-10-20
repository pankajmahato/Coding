/**********************************************************************************
 *
 * https://leetcode.com/problems/count-the-number-of-fair-pairs/
 *
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 *
 * A pair (i, j) is fair if:
 *
 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * Output: 6
 * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 * Example 2:
 *
 * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
 * Output: 1
 * Explanation: There is a single fair pair: (2,3).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums.length == n
 * -109 <= nums[i] <= 109
 * -109 <= lower <= upper <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

import java.util.Arrays;

public class _2563_Count_the_Number_of_Fair_Pairs {

    public long countFairPairs(int[] nums, int lower, int upper) {

        // Observation
        // We have to find pairs p such that p>=lower & p<=upper
        // If pairs x is such that x < lower and if pairs y is such that y <= upper
        // Then (y-x) = p

        int n = nums.length;

        Arrays.sort(nums);

        long result = 0;

        for (int i = 0; i < n; i++) {

            int xIdx = getLowerIndex(nums, n, lower - nums[i]);
            int x = xIdx - i;

            int yIdx = getLowerIndex(nums, n, upper - nums[i] + 1);
            int y = yIdx - i;

            result += (y < 0 ? 0 : y) - (x < 0 ? 0 : x);
        }

        return result;
    }

    private int getLowerIndex(int[] nums, int n, int target) {

        int l = 0;
        int r = n - 1;

        int result = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}

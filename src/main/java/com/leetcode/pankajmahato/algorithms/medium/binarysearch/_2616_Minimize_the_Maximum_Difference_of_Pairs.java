/**********************************************************************************
 *
 * https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
 *
 * You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.
 *
 * Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.
 *
 * Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,1,2,7,1,3], p = 2
 * Output: 1
 * Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
 * The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
 * Example 2:
 *
 * Input: nums = [4,2,1,2], p = 1
 * Output: 0
 * Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= p <= (nums.length)/2
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

import java.util.Arrays;

public class _2616_Minimize_the_Maximum_Difference_of_Pairs {

    public int minimizeMax(int[] nums, int p) {

        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = nums[n - 1] - nums[0];

        int result = n;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (isValid(nums, mid, p)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    private boolean isValid(int[] nums, int target, int p) {

        int n = nums.length;

        int i = 0;
        int count = 0;
        while (i < n - 1) {

            if (nums[i + 1] - nums[i] <= target) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= p;
    }
}

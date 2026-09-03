/**********************************************************************************
 *
 * https://leetcode.com/problems/count-alternating-subarrays/
 *
 * You are given a binary array nums.
 *
 * We call a subarray alternating if no two adjacent elements in the subarray have the same value.
 *
 * Return the number of alternating subarrays in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,1,1]
 *
 * Output: 5
 *
 * Explanation:
 *
 * The following subarrays are alternating: [0], [1], [1], [1], and [0,1].
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,0]
 *
 * Output: 10
 *
 * Explanation:
 *
 * Every subarray of the array is alternating. There are 10 possible subarrays that we can choose.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _3101_Count_Alternating_Subarrays {

    public long countAlternatingSubarrays(int[] nums) {

        int n = nums.length;

        long result = 0;

        for (int i = 0; i < n; i++) {

            int j = i;

            while (j + 1 < n && nums[j] != nums[j + 1]) {
                j++;
            }

            long len = j - i + 1;
            result = result + len * (len + 1) / 2;

            i = j;
        }

        return result;
    }
}

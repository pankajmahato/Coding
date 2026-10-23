/**********************************************************************************
 *
 * https://leetcode.com/problems/contiguous-array/
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _525_Contiguous_Array {

    public int findMaxLength(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                sum = sum - 1;
            } else {
                sum = sum + nums[i];
            }

            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return result;
    }
}

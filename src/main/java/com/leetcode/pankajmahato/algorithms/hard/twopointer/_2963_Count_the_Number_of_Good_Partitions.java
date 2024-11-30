/**********************************************************************************
 *
 * https://leetcode.com/problems/count-the-number-of-good-partitions/
 *
 * You are given a 0-indexed array nums consisting of positive integers.
 *
 * A partition of an array into one or more contiguous subarrays is called good if no two subarrays contain the same number.
 *
 * Return the total number of good partitions of nums.
 *
 * Since the answer may be large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 8
 * Explanation: The 8 possible good partitions are: ([1], [2], [3], [4]), ([1], [2], [3,4]), ([1], [2,3], [4]), ([1], [2,3,4]), ([1,2], [3], [4]), ([1,2], [3,4]), ([1,2,3], [4]), and ([1,2,3,4]).
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 1
 * Explanation: The only possible good partition is: ([1,1,1,1]).
 * Example 3:
 *
 * Input: nums = [1,2,1,3]
 * Output: 2
 * Explanation: The 2 possible good partitions are: ([1,2,1], [3]) and ([1,2,1,3]).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.twopointer;

import java.util.HashMap;
import java.util.Map;

public class _2963_Count_the_Number_of_Good_Partitions {

    public int numberOfGoodPartitions(int[] nums) {

        // Map<Number, last Index>
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int result = 1;

        int i = 0;
        int j = map.get(nums[0]);

        while (i < n) {

            if (i > j) {
                result = (result * 2) % mod;
            }
            j = Math.max(j, map.get(nums[i]));
            i++;
        }

        return result;
    }
}

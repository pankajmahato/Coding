/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow up: Could you implement the O(n) solution?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashSet;
import java.util.Set;

public class _128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        for (int num : numSet) {

            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int count = 1;
                while (numSet.contains(++currNum)) {
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}

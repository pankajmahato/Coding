/**********************************************************************************
 *
 * https://leetcode.com/problems/the-number-of-beautiful-subsets/
 *
 * You are given an array nums of positive integers and a positive integer k.
 *
 * A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.
 *
 * Return the number of non-empty beautiful subsets of the array nums.
 *
 * A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,4,6], k = 2
 * Output: 4
 * Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
 * It can be proved that there are only 4 beautiful subsets in the array [2,4,6].
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: 1
 * Explanation: The beautiful subset of the array nums is [1].
 * It can be proved that there is only 1 beautiful subset in the array [1].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 1 <= nums[i], k <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;


import java.util.HashMap;
import java.util.Map;

public class _2597_The_Number_of_Beautiful_Subsets {
    public int beautifulSubsets(int[] nums, int k) {

        Map<Integer, Integer> temp = new HashMap<>();

        return backtrack(nums, k, 0, temp) - 1;
    }

    private int backtrack(int[] nums, int k, int i, Map<Integer, Integer> temp) {

        if (i == nums.length) {
            return 1;
        }

        int count = 0;
        if (!temp.containsKey(nums[i] + k) && !temp.containsKey(nums[i] - k)) {
            temp.put(nums[i], temp.getOrDefault(nums[i], 0) + 1);
            count += backtrack(nums, k, i + 1, temp);
            temp.put(nums[i], temp.get(nums[i]) - 1);
            if (temp.get(nums[i]) == 0) {
                temp.remove(nums[i]);
            }
        }
        count += backtrack(nums, k, i + 1, temp);
        return count;
    }

}

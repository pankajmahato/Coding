/**********************************************************************************
 *
 * https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible 
 * permutations
 * . You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> result) {

        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {

            int t = nums[idx];
            nums[idx] = nums[i];
            nums[i] = t;
            backtrack(nums, idx + 1, result);
            t = nums[idx];
            nums[idx] = nums[i];
            nums[i] = t;
        }
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible 
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;


import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(nums, 0, temp, result);
        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> temp, List<List<Integer>> result) {

        if (idx == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        backtrack(nums, idx + 1, temp, result);
        temp.add(nums[idx]);
        backtrack(nums, idx + 1, temp, result);
        temp.remove(temp.size() - 1);
    }

}

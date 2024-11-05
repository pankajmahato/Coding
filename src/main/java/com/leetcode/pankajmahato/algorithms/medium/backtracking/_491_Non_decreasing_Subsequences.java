/**********************************************************************************
 *
 * https://leetcode.com/problems/non-decreasing-subsequences/
 *
 * Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Example 2:
 *
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _491_Non_decreasing_Subsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(nums, n, 0, curr, result);

        return result;
    }

    private void backtrack(int[] nums, int n, int idx, List<Integer> curr, List<List<Integer>> result) {

        if (curr.size() >= 2) {
            result.add(new ArrayList<>(curr));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = idx; i < n; i++) {

            if ((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) && !used.contains(nums[i])) {

                curr.add(nums[i]);
                backtrack(nums, n, i + 1, curr, result);
                curr.remove(curr.size() - 1);

                used.add(nums[i]);
            }
        }
    }
}

/**********************************************************************************
 *
 * https://leetcode.com/problems/permutations-ii/
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _47_Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {

        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        // Num -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        solve(map, n, curr, result);
        return result;
    }

    private void solve(Map<Integer, Integer> map, int n, List<Integer> curr, List<List<Integer>> result) {

        if (curr.size() == n) {
            List<Integer> val = new ArrayList<>(n);
            val.addAll(curr);
            result.add(val);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                continue;
            }

            map.put(num, count - 1);
            curr.add(num);

            solve(map, n, curr, result);

            map.put(num, count);
            curr.remove(curr.size() - 1);
        }
    }
}

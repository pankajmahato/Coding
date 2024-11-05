/**********************************************************************************
 *
 * https://leetcode.com/problems/find-the-minimum-cost-array-permutation/
 *
 * You are given an array nums which is a 
 * permutation
 *  of [0, 1, 2, ..., n - 1]. The score of any permutation of [0, 1, 2, ..., n - 1] named perm is defined as:
 *
 * score(perm) = |perm[0] - nums[perm[1]]| + |perm[1] - nums[perm[2]]| + ... + |perm[n - 1] - nums[perm[0]]|
 *
 * Return the permutation perm which has the minimum possible score. If multiple permutations exist with this score, return the one that is 
 * lexicographically smallest
 *  among them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,2]
 *
 * Output: [0,1,2]
 *
 * Explanation:
 *
 *
 *
 * The lexicographically smallest permutation with minimum cost is [0,1,2]. The cost of this permutation is |0 - 0| + |1 - 2| + |2 - 1| = 2.
 *
 * Example 2:
 *
 * Input: nums = [0,2,1]
 *
 * Output: [0,2,1]
 *
 * Explanation:
 *
 *
 *
 * The lexicographically smallest permutation with minimum cost is [0,2,1]. The cost of this permutation is |0 - 1| + |2 - 2| + |1 - 0| = 2.
 *
 *
 *
 * Constraints:
 *
 * 2 <= n == nums.length <= 14
 * nums is a permutation of [0, 1, 2, ..., n - 1].
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _3149_Find_the_Minimum_Cost_Array_Permutation {

    int minScore = Integer.MAX_VALUE;
    List<Integer> result = new ArrayList<>();

    public int[] findPermutation(int[] nums) {

        List<Integer> perm = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        perm.add(0);
        visited[0] = true;
        backtrack(nums, perm, visited, 0);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void backtrack(int[] nums, List<Integer> perm, boolean[] visited, int score) {

        if (minScore <= score) {
            return;
        }
        if (perm.size() == nums.length) {

            score = score + Math.abs(perm.get(perm.size() - 1) - nums[perm.get(0)]);
            if (score < minScore) {
                minScore = score;
                result = new ArrayList(perm);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                perm.add(i);
                int size = perm.size();
                backtrack(nums, perm, visited, score + Math.abs(perm.get(size - 2) - nums[perm.get(size - 1)]));
                visited[i] = false;
                perm.remove(size - 1);
            }
        }
    }
}

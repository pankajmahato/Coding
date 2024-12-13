/**********************************************************************************
 *
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 *
 *
 * Constraints:
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * There exists some nums that has adjacentPairs as its pairs.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1743_Restore_the_Array_From_Adjacent_Pairs {

    public int[] restoreArray(int[][] adjacentPairs) {

        // 1. Create adj list
        // 2. Find any 1 node with only 1 edge
        // 3. DFS from the above node

        int n = adjacentPairs.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // 1. Create adj list
        for (int[] pair : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // 2. Find any 1 node with only 1 edge
        int node = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            if (entry.getValue().size() == 1) {
                node = entry.getKey();
                break;
            }
        }

        // 3. DFS from the above node
        int[] result = new int[n + 1];
        Set<Integer> visited = new HashSet<>();
        visited.add(node);
        result[0] = node;
        int i = 1;
        while (visited.size() != n + 1) {
            List<Integer> next = adj.get(node);
            for (int val : next) {
                if (!visited.contains(val)) {
                    result[i] = val;
                    visited.add(val);
                    i++;
                    node = val;
                }
            }
        }

        return result;
    }
}

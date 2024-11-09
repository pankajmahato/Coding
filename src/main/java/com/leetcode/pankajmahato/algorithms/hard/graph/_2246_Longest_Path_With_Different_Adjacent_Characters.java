/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
 *
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.
 *
 * You are also given a string s of length n, where s[i] is the character assigned to node i.
 *
 * Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: parent = [-1,0,0,1,1,2], s = "abacbe"
 * Output: 3
 * Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3 is returned.
 * It can be proven that there is no longer path that satisfies the conditions. 
 * Example 2:
 *
 *
 * Input: parent = [-1,0,0,0], s = "aabc"
 * Output: 3
 * Explanation: The longest path where each two adjacent nodes have different characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is returned.
 *
 *
 * Constraints:
 *
 * n == parent.length == s.length
 * 1 <= n <= 105
 * 0 <= parent[i] <= n - 1 for all i >= 1
 * parent[0] == -1
 * parent represents a valid tree.
 * s consists of only lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2246_Longest_Path_With_Different_Adjacent_Characters {

    int result;

    public int longestPath(int[] parent, String s) {

        int n = parent.length;

        // Create Adjacency List
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Initialise with empty array
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Add Edges
        for (int i = 1; i < n; i++) {
            int u = parent[i];
            int v = i;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        result = 0;
        dfs(adj, 0, -1, s);

        return result;
    }

    private int dfs(Map<Integer, List<Integer>> adj, int curr, int parent, String s) {

        int longest = 0;
        int secondLongest = 0;

        for (int child : adj.get(curr)) {

            if (child == parent) {
                continue;
            }

            int childLength = dfs(adj, child, curr, s);

            // Go to depth and then check if adjacent is equal
            if (s.charAt(child) == s.charAt(curr)) {
                continue;
            }
            if (secondLongest < childLength) {
                secondLongest = childLength;
            }

            if (longest < secondLongest) {
                int temp = longest;
                longest = secondLongest;
                secondLongest = temp;
            }
        }

        // Case 1: Longest path is below current node
        int maxLengthBelowCurr = 1 + longest + secondLongest;

        // Case 2: Longest path is either of 'longest' or 'secondLongest'
        int maxLengthOfAnyChild = 1 + Math.max(longest, secondLongest);

        // Case 3: No path from child
        int noChildLength = 1;

        result = Collections.max(Arrays.asList(result, maxLengthBelowCurr, maxLengthOfAnyChild, noChildLength));

        return Math.max(maxLengthOfAnyChild, noChildLength);
    }

}

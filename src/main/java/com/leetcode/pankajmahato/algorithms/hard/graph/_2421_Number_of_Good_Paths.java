/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-good-paths/
 *
 * There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 *
 * You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 *
 * A good path is a simple path that satisfies the following conditions:
 *
 * The starting node and the ending node have the same value.
 * All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
 * Return the number of distinct good paths.
 *
 * Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
 * Output: 6
 * Explanation: There are 5 good paths consisting of a single node.
 * There is 1 additional good path: 1 -> 0 -> 2 -> 4.
 * (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
 * Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
 * Example 2:
 *
 *
 * Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
 * Output: 7
 * Explanation: There are 5 good paths consisting of a single node.
 * There are 2 additional good paths: 0 -> 1 and 2 -> 3.
 * Example 3:
 *
 *
 * Input: vals = [1], edges = []
 * Output: 1
 * Explanation: The tree consists of only one node, so there is one good path.
 *
 *
 * Constraints:
 *
 * n == vals.length
 * 1 <= n <= 3 * 104
 * 0 <= vals[i] <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.graph;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _2421_Number_of_Good_Paths {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        int n = vals.length;
        // Initialise adjacency List
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Store label to node in ascending label order
        TreeMap<Integer, List<Integer>> labelToNode = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            labelToNode.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Single node is a valid path
        int result = n;

        // Store if the Node is active
        boolean[] isActive = new boolean[n];

        // Loop over the labels in ascending order
        for (Map.Entry<Integer, List<Integer>> entry : labelToNode.entrySet()) {

            // For every label's node Union it with their edge node
            List<Integer> labelNodes = entry.getValue();
            for (int u : labelNodes) {

                for (int v : adj.get(u)) {
                    // Union only if the node is active
                    if (isActive[v] == true) {
                        union(u, v, parent, rank);
                    }
                }

                isActive[u] = true;
            }

            List<Integer> labelNodeParent = new ArrayList<>();

            // For every label's node find its parent
            for (int u : labelNodes) {

                int p = find(u, parent);
                labelNodeParent.add(p);
            }

            // Sort the parents to get the counts easily
            Collections.sort(labelNodeParent);

            int size = labelNodeParent.size();
            for (int i = 0; i < size; i++) {

                // Get the current parent
                int currParent = labelNodeParent.get(i);
                int count = 0;

                // Count the number of repetitinos of this parent
                while (i < size && currParent == labelNodeParent.get(i)) {
                    count++;
                    i++;
                }
                i--;

                // Use nC2 to get the number of possible paths
                int noOfPaths = count * (count - 1) / 2;
                result += noOfPaths;

            }
        }

        return result;
    }

    private int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank) {

        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else {
            parent[yParent] = xParent;
        }
    }

}

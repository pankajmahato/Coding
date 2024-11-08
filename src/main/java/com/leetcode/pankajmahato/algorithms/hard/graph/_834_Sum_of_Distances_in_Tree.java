/**********************************************************************************
 *
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 *
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 *
 * You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation: The tree is shown above.
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.
 * Hence, answer[0] = 8, and so on.
 * Example 2:
 *
 *
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 3:
 *
 *
 * Input: n = 2, edges = [[1,0]]
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 3 * 104
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * The given input represents a valid tree.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _834_Sum_of_Distances_in_Tree {

    int rootResult = 0;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] count = new int[n];
        // Calculate count of child nodes for every node
        dfsRoot(adj, 0, -1, 0, count);

        int[] allDistNode = new int[n];
        allDistNode[0] = rootResult;
        // Calculate distance for every node from curr and parent node
        dfsAllNodeDist(n, adj, 0, -1, count, allDistNode);

        return allDistNode;
    }

    private int dfsRoot(Map<Integer, List<Integer>> adj, int curr, int parent, int depth, int[] count) {

        int totalCount = 1;

        // Store count of root node
        rootResult += depth;

        for (int child : adj.getOrDefault(curr, new ArrayList<>())) {
            if (child != parent) {
                totalCount += dfsRoot(adj, child, curr, depth + 1, count);
            }
        }

        count[curr] = totalCount;

        return totalCount;

    }

    private void dfsAllNodeDist(int n, Map<Integer, List<Integer>> adj, int curr, int parent, int[] count, int[] allDistNode) {

        for (int child : adj.getOrDefault(curr, new ArrayList<>())) {
            if (child != parent) {

                allDistNode[child] = allDistNode[curr] - count[child] + (n - count[child]);
                dfsAllNodeDist(n, adj, child, curr, count, allDistNode);
            }
        }
    }

}

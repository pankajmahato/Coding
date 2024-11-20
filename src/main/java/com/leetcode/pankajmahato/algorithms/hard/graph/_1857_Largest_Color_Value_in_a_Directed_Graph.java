/**********************************************************************************
 *
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 *
 * There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
 *
 * You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.
 *
 * A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.
 *
 * Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
 * Example 2:
 *
 *
 *
 * Input: colors = "a", edges = [[0,0]]
 * Output: -1
 * Explanation: There is a cycle from 0 to 0.
 *
 *
 * Constraints:
 *
 * n == colors.length
 * m == edges.length
 * 1 <= n <= 105
 * 0 <= m <= 105
 * colors consists of lowercase English letters.
 * 0 <= aj, bj < n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _1857_Largest_Color_Value_in_a_Directed_Graph {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        int nodeCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[][] colorMap = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                colorMap[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {

            int u = queue.remove();
            nodeCount++;

            result = Math.max(result, colorMap[u][colors.charAt(u) - 'a']);

            for (int v : adj.get(u)) {

                for (int c = 0; c < 26; c++) {
                    colorMap[v][c] = Math.max(colorMap[v][c], colorMap[u][c] + (colors.charAt(v) - 'a' == c ? 1 : 0));
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (nodeCount < n) {
            return -1;
        }

        return result;
    }

}

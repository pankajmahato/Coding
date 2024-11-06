/**********************************************************************************
 *
 * https://leetcode.com/problems/possible-bipartition/
 *
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: The first group has [1,4], and the second group has [2,3].
 * Example 2:
 *
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= ai < bi <= n
 * All the pairs of dislikes are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _886_Possible_Bipartition {

//    public boolean possibleBipartition(int n, int[][] dislikes) {
//
//        // BFS
//        int[] color = new int[n + 1];
//        Arrays.fill(color, -1);
//
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        for (int[] edge : dislikes) {
//            int u = edge[0];
//            int v = edge[1];
//            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
//            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (color[i] == -1) {
//                if (bfs(adj, i, 0, color) == false) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    private boolean bfs(Map<Integer, List<Integer>> adj, int node, int currColor,
//                        int[] color) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(node);
//        color[node] = currColor;
//
//        while (!queue.isEmpty()) {
//
//            int u = queue.remove();
//
//            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
//                if (color[v] == color[u]) {
//                    return false;
//                }
//
//                if (color[v] == -1) {
//                    color[v] = 1 - color[u];
//                    queue.add(v);
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean possibleBipartition(int n, int[][] dislikes) {

        // DFS
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (dfs(adj, i, 0, color) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, int node, int currColor, int[] color) {

        color[node] = currColor;

        for (int v : adj.getOrDefault(node, new ArrayList<>())) {
            if (color[v] == currColor) {
                return false;
            }

            if (color[v] == -1) {
                if (dfs(adj, v, 1 - currColor, color) == false) {
                    return false;
                }
            }
        }

        return true;
    }

}

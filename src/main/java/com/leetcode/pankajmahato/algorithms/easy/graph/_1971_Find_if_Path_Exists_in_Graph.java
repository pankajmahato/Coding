/**********************************************************************************
 *
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _1971_Find_if_Path_Exists_in_Graph {

//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//
//        // BFS
//        boolean[] visited = new boolean[n];
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        for (int[] edge : edges) {
//
//            int u = edge[0];
//            int v = edge[1];
//
//            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
//            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(source);
//        visited[source] = true;
//
//        while (!queue.isEmpty()) {
//
//            int node = queue.remove();
//
//            if (node == destination) {
//                return true;
//            }
//
//            for (int v : adj.get(node)) {
//
//                if (visited[v] == false) {
//                    queue.add(v);
//                    visited[v] = true;
//                }
//            }
//        }
//
//        return false;
//    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // DFS
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return dfs(adj, source, destination, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> adj, int source, int destination, boolean[] visited) {

        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int v : adj.get(source)) {
            if (visited[v] == false) {
                if (dfs(adj, v, destination, visited) == true) {
                    return true;
                }
            }
        }

        return false;
    }

}

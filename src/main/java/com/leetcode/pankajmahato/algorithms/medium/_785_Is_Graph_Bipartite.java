/**********************************************************************************
 *
 * https://leetcode.com/problems/is-graph-bipartite/
 *
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
 * Example 2:
 *
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 *
 *
 * Constraints:
 *
 * graph.length == n
 * 1 <= n <= 100
 * 0 <= graph[u].length < n
 * 0 <= graph[u][i] <= n - 1
 * graph[u] does not contain u.
 * All the values of graph[u] are unique.
 * If graph[u] contains v, then graph[v] contains u.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _785_Is_Graph_Bipartite {
//    public boolean isBipartite(int[][] graph) {
//
//        int[] color = new int[graph.length];
//        Arrays.fill(color, -1);
//        for (int i = 0; i < graph.length; i++) {
//            if (color[i] == -1) {
//                if (DFS(graph, i, color, 0) == false) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    private boolean DFS(int[][] graph, int curr, int[] color, int currColor) {
//
//        color[curr] = currColor;
//
//        for (int v : graph[curr]) {
//            if (color[v] == color[curr]) {
//                return false;
//            }
//
//            if (color[v] == -1) {
//                if (DFS(graph, v, color, 1 - currColor) == false) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (BFS(graph, i, color, 0) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean BFS(int[][] graph, int curr, int[] color, int currColor) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        color[curr] = currColor;

        while (!queue.isEmpty()) {

            int u = queue.remove();

            for (int v : graph[u]) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
                if (color[v] == color[u]) {
                    return false;
                }
            }
        }

        return true;
    }

}

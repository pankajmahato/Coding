/**********************************************************************************
 *
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 *
 * You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 *
 * Return the number of pairs of different nodes that are unreachable from each other.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[0,2],[1,2]]
 * Output: 0
 * Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
 * Example 2:
 *
 *
 * Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * Output: 14
 * Explanation: There are 14 pairs of nodes that are unreachable from each other:
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
 * Therefore, we return 14.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no repeated edges.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _2316_Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {

//    public long countPairs(int n, int[][] edges) {
//
//        // DFS
//        boolean[] visited = new boolean[n];
//        int size = n;
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            adj.put(i, new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            adj.get(edge[0]).add(edge[1]);
//            adj.get(edge[1]).add(edge[0]);
//        }
//
//        long total = 0;
//        for (int i = 0; i < n; i++) {
//            if (visited[i] == false) {
//                int componentSize = DFS(adj, i, visited);
//                total += (long) componentSize * (size - componentSize);
//                size = size - componentSize;
//            }
//        }
//
//        return total;
//    }
//
//    private int DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
//
//        int count = 0;
//        visited[u] = true;
//        count++;
//        for (int v : adj.get(u)) {
//            if (visited[v] == false) {
//                count += DFS(adj, v, visited);
//            }
//        }
//
//        return count;
//    }

//    public long countPairs(int n, int[][] edges) {
//        // BFS
//        boolean[] visited = new boolean[n];
//        int size = n;
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            adj.put(i, new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            adj.get(edge[0]).add(edge[1]);
//            adj.get(edge[1]).add(edge[0]);
//        }
//
//        long total = 0;
//        for (int i = 0; i < n; i++) {
//            if (visited[i] == false) {
//                int componentSize = BFS(adj, i, visited);
//                total += (long) componentSize * (size - componentSize);
//                size = size - componentSize;
//            }
//        }
//
//        return total;
//    }
//
//    private int BFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
//
//        int count = 0;
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(u);
//
//        visited[u] = true;
//        count++;
//
//        while (!queue.isEmpty()) {
//            int node = queue.remove();
//
//            for (int v : adj.get(node)) {
//                if (visited[v] == false) {
//                    queue.add(v);
//                    visited[v] = true;
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

    public long countPairs(int n, int[][] edges) {
        // DSU
        int[] parent = new int[n];
        int[] rank = new int[n];
        int size = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank);
        }

        Map<Integer, Integer> componentSizeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i, parent);
            componentSizeMap.put(p, componentSizeMap.getOrDefault(p, 0) + 1);
        }

        long total = 0;
        for (Map.Entry<Integer, Integer> entry : componentSizeMap.entrySet()) {
            int componentSize = entry.getValue();
            total += (long) componentSize * (size - componentSize);
            size = size - componentSize;
        }

        return total;
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
            rank[yParent]++;
        }
    }
    
}

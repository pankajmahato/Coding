/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-provinces/
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.LinkedList;
import java.util.Queue;

public class _547_Number_of_Provinces {
//    public int findCircleNum(int[][] isConnected) {
//
//        Map<Integer, List<Integer>> adj = new HashMap<>();
//
//        for (int i = 0; i < isConnected.length; i++) {
//            adj.put(i, new ArrayList<>());
//            for (int j = 0; j < isConnected[i].length; j++) {
//                if (isConnected[i][j] == 1) {
//                    adj.get(i).add(j);
//                }
//            }
//        }
//
//        boolean[] visited = new boolean[isConnected.length];
//
//        int count = 0;
//        for (int i = 0; i < isConnected.length; i++) {
//            if (!visited[i]) {
//                DFS(adj, i, visited);
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//    private void DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
//
//        visited[u] = true;
//        for (Integer v : adj.get(u)) {
//            if (!visited[v]) {
//                DFS(adj, v, visited);
//            }
//        }
//    }

    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];

        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                // DFS(isConnected, i, visited);
                BFS(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }

    private void DFS(int[][] isConnected, int u, boolean[] visited) {

        visited[u] = true;
        for (int v = 0; v < isConnected.length; v++) {
            if (!visited[v] && isConnected[u][v] == 1) {
                DFS(isConnected, v, visited);
            }
        }
    }

    private void BFS(int[][] isConnected, int u, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int v = 0; v < isConnected.length; v++) {
                if (!visited[v] && isConnected[u][v] == 1) {
                    BFS(isConnected, v, visited);
                }
            }
        }
    }

}

/**********************************************************************************
 *
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 2:
 *
 *
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 3:
 *
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

    public int minReorder(int n, int[][] connections) {

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];

            // Add original edge
            adj.get(u).add(new int[]{v, 1});
            // Add fake edge
            adj.get(v).add(new int[]{u, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(adj, 0, visited);
    }

    private int dfs(Map<Integer, List<int[]>> adj, int u, boolean[] visited) {

        visited[u] = true;

        int count = 0;

        for (int[] v : adj.get(u)) {
            if (visited[v[0]] == false) {
                if (v[1] == 1) {
                    count++;
                }
                count += dfs(adj, v[0], visited);
            }
        }
        return count;
    }

}

/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 *
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8 
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
 * Example 2:
 *
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
 * Example 3:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * hasApple.length == n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1443_Minimum_Time_to_Collect_All_Apples_in_a_Tree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

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

        return dfs(adj, 0, -1, hasApple);
    }

    private int dfs(Map<Integer, List<Integer>> adj, int curr, int parent, List<Boolean> hasApple) {

        int total = 0;

        for (int child : adj.get(curr)) {

            if (child != parent) {
                int childTime = dfs(adj, child, curr, hasApple);

                if (childTime > 0 || hasApple.get(child) == true) {
                    total += childTime + 2;
                }
            }
        }

        return total;
    }

}

/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
 *
 * You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
 *
 * The score of a path between two cities is defined as the minimum distance of a road in this path.
 *
 * Return the minimum possible score of a path between cities 1 and n.
 *
 * Note:
 *
 * A path is a sequence of roads between two cities.
 * It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
 * The test cases are generated such that there is at least one path between 1 and n.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * Output: 5
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
 * It can be shown that no other path has less score.
 * Example 2:
 *
 *
 * Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * Output: 2
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 105
 * 1 <= roads.length <= 105
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 104
 * There are no repeated edges.
 * There is at least one path between 1 and n.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _2492_Minimum_Score_of_a_Path_Between_Two_Cities {

//    public int minScore(int n, int[][] roads) {
////     BFS
//        boolean[] visited = new boolean[n + 1];
//        Map<Integer, List<int[]>> adj = new HashMap<>();
//        for (int i = 1; i <= n; i++) {
//            adj.put(i, new ArrayList<>());
//        }
//
//        for (int[] road : roads) {
//            int u = road[0];
//            int v = road[1];
//            int dist = road[2];
//            adj.get(u).add(new int[]{v, dist});
//            adj.get(v).add(new int[]{u, dist});
//        }
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{1, Integer.MAX_VALUE});
//        visited[1] = true;
//
//        int result = Integer.MAX_VALUE;
//
//        while (!queue.isEmpty()) {
//
//            int uNode = queue.peek()[0];
//            int uDist = queue.peek()[1];
//            queue.remove();
//
//            for (int[] v : adj.get(uNode)) {
//
//                int vNode = v[0];
//                int vDist = v[1];
//                result = Math.min(result, vDist);
//                if (visited[vNode] == false) {
//                    visited[vNode] = true;
//                    queue.add(v);
//                }
//            }
//        }
//
//        return result;
//    }

    public int minScore(int n, int[][] roads) {

        // DFS
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            adj.get(u).add(new int[]{v, dist});
            adj.get(v).add(new int[]{u, dist});
        }

        return dfs(adj, 1, Integer.MAX_VALUE, visited);
    }

    private int dfs(Map<Integer, List<int[]>> adj, int uNode, int uDist, boolean[] visited) {

        int result = Integer.MAX_VALUE;
        visited[uNode] = true;
        for (int[] v : adj.get(uNode)) {

            int vNode = v[0];
            int vDist = v[1];
            result = Math.min(result, vDist);
            if (visited[vNode] == false) {
                visited[vNode] = true;
                result = Math.min(result, dfs(adj, vNode, vDist, visited));
            }
        }
        return result;
    }

}

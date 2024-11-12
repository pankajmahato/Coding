/**********************************************************************************
 *
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
 *
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 *
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from i, then edges[i] == -1.
 *
 * You are also given two integers node1 and node2.
 *
 * Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.
 *
 * Note that edges may contain cycles.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
 * The maximum of those two distances is 1. It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.
 * Example 2:
 *
 *
 * Input: edges = [1,2,-1], node1 = 0, node2 = 2
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 2, and the distance from node 2 to itself is 0.
 * The maximum of those two distances is 2. It can be proven that we cannot get a node with a smaller maximum distance than 2, so we return node 2.
 *
 *
 * Constraints:
 *
 * n == edges.length
 * 2 <= n <= 105
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _2359_Find_Closest_Node_to_Given_Two_Nodes {

//    public int closestMeetingNode(int[] edges, int node1, int node2) {
//
//        // DFS
//        int n = edges.length;
//        boolean[] visited1 = new boolean[n];
//        int[] distance1 = new int[n];
//        Arrays.fill(distance1, Integer.MAX_VALUE);
//        distance1[node1] = 0;
//
//        boolean[] visited2 = new boolean[n];
//        int[] distance2 = new int[n];
//        Arrays.fill(distance2, Integer.MAX_VALUE);
//        distance2[node2] = 0;
//
//        dfs(edges, node1, distance1, visited1);
//        dfs(edges, node2, distance2, visited2);
//
//        int dist = Integer.MAX_VALUE;
//        int result = -1;
//
//        for (int i = 0; i < n; i++) {
//            if (distance1[i] != Integer.MAX_VALUE && distance2[i] != Integer.MAX_VALUE) {
//                int max = Math.max(distance1[i], distance2[i]);
//                if (max < dist) {
//                    dist = max;
//                    result = i;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private void dfs(int[] edges, int node, int[] distance, boolean[] visited) {
//
//        visited[node] = true;
//
//        int v = edges[node];
//        if (v != -1 && visited[v] == false) {
//            visited[v] = true;
//            distance[v] = distance[node] + 1;
//            dfs(edges, v, distance, visited);
//        }
//    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        // BFS
        int n = edges.length;
        int[] distance1 = new int[n];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        distance1[node1] = 0;

        int[] distance2 = new int[n];
        Arrays.fill(distance2, Integer.MAX_VALUE);
        distance2[node2] = 0;

        bfs(edges, node1, distance1);
        bfs(edges, node2, distance2);

        int dist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (distance1[i] != Integer.MAX_VALUE && distance2[i] != Integer.MAX_VALUE) {
                int max = Math.max(distance1[i], distance2[i]);
                if (max < dist) {
                    dist = max;
                    result = i;
                }
            }
        }

        return result;
    }

    private void bfs(int[] edges, int node, int[] distance) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];

        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int u = queue.remove();

            int v = edges[u];

            if (v != -1 && visited[v] == false) {
                visited[v] = true;
                distance[v] = distance[u] + 1;
                queue.add(v);
            }
        }
    }

}

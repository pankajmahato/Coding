/**********************************************************************************
 *
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 *
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation: 
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * All pairs (xi, yi) are distinct.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _1584_Min_Cost_to_Connect_All_Points {

//    public int minCostConnectPoints(int[][] points) {
//
//        // Prim's
//        int v = points.length;
//        int[][] adj = new int[v][v];
//
//        for (int i = 0; i < v; i++) {
//            for (int j = i + 1; j < v; j++) {
//                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
//                adj[i][j] = dist;
//                adj[j][i] = dist;
//            }
//        }
//
//        boolean[] inMST = new boolean[v];
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
//        int cost = 0;
//
//        queue.add(new int[]{0, 0});
//
//        while (!queue.isEmpty()) {
//
//            int[] val = queue.remove();
//            int weight = val[0];
//            int node = val[1];
//
//            if (inMST[node] == true) {
//                continue;
//            }
//
//            inMST[node] = true;
//            cost += weight;
//
//            for (int j = 0; j < v; j++) {
//                int next = j;
//                int nextWeight = adj[node][j];
//                if (inMST[next] == false) {
//                    queue.add(new int[]{nextWeight, next});
//                }
//            }
//        }
//
//        return cost;
//    }

    public int minCostConnectPoints(int[][] points) {

        //kruskal's
        int n = points.length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new int[]{weight, i, j});
            }
        }

        edges.sort((a, b) -> a[0] - b[0]);
        int sum = 0;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int w = edge[0];
            int u = edge[1];
            int v = edge[2];

            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if (parent_u != parent_v) {
                union(u, v, parent, rank);
                sum += w;
            }
        }

        return sum;
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

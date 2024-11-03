/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * Example 2:
 *
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * 1 <= connections.length <= min(n * (n - 1) / 2, 105)
 * connections[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


public class _1319_Number_of_Operations_to_Make_Network_Connected {

    public int makeConnected(int n, int[][] connections) {

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;
        if (connections.length < n - 1) {
            return -1;
        }

        for (int[] con : connections) {
            if (union(con[0], con[1], parent, rank)) {
                components--;
            }
        }

        return components - 1;

    }

    int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    boolean union(int x, int y, int[] parent, int[] rank) {

        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent) {
            return false;
        }

        if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else {
            parent[yParent] = xParent;
            rank[yParent]++;
        }

        return true;
    }

}

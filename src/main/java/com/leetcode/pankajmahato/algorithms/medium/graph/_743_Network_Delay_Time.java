/**********************************************************************************
 *
 * https://leetcode.com/problems/network-delay-time/
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _743_Network_Delay_Time {

    public int networkDelayTime(int[][] times, int n, int k) {

        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[]{v, w});
        }

        queue.add(new int[]{k, 0});

        while (!queue.isEmpty()) {
            int source = queue.peek()[0];
            int weight = queue.peek()[1];
            queue.poll();

            for (int[] edge : adj.get(source)) {
                int edgeNode = edge[0];
                int edgeWeight = edge[1];

                int newWeight = weight + edgeWeight;
                if (newWeight < result[edgeNode]) {
                    result[edgeNode] = newWeight;
                    queue.add(new int[]{edgeNode, newWeight});
                }
            }
        }

        int maxDelay = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (maxDelay < result[i]) {
                maxDelay = result[i];
            }
        }

        if (maxDelay == Integer.MAX_VALUE) {
            return -1;
        }

        return maxDelay;

    }

}
